package de.hstr.db.jdbcexample;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// @formatter:off

public class RandomExams {
    public static void main(String[] args) throws SQLException {
        String jdbcUrl = "jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'src/main/resources/init.sql'";
        DriverManager.registerDriver(new org.h2.Driver());
        try (Connection conn = DriverManager.getConnection(jdbcUrl)) {
            Map<Integer, String> prof = readTable(conn, "professoren", "persnr", "name");
            Map<Integer, String> vorl = readTable(conn, "vorlesungen", "vorlnr", "titel");
            Map<Integer, String> stud = readTable(conn, "studenten", "matrnr", "name");

            System.err.println(prof);
            System.err.println(vorl);
            System.err.println(stud);

            Map<Integer, Integer> gelesenVon = readVorl(conn);

            System.err.println(gelesenVon);

            hoerenAuflisten(conn, vorl, stud);
            zufaelligeNoten(conn, vorl, stud, gelesenVon);

            System.err.println();

            DatabaseMetaData meta = conn.getMetaData();

            try (ResultSet tables = meta.getTables(null, null, "%", null)) {
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");
                    System.err.println(tableName);

                    try (ResultSet columns = meta.getColumns(null, null, tableName, "%")) {
                        while (columns.next()) {
                            String column = columns.getString("COLUMN_NAME");
                            System.err.println("  " + column);
                        }
                    }

                    System.err.println();
                }
            }
        }
    }

    private static void hoerenAuflisten(Connection conn, Map<Integer, String> vorl, Map<Integer, String> stud) throws SQLException {
        try (var statement = conn.createStatement();
             var result    = statement.executeQuery("select matrnr, vorlnr from hoeren"))
        {
            while (result.next()) {
                System.err.println(stud.get(result.getInt(1)) + " hoert " + vorl.get(result.getInt(2)));
            }
        }
    }

    private static void zufaelligeNoten(Connection conn, Map<Integer, String> vorl, Map<Integer, String> stud, Map<Integer, Integer> gelesenVon) throws SQLException {
        Random rnd = new Random();

        Collection<Double>  noten       = Set.of(1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0, 5.0);
        Collection<Integer> studenten   = stud.keySet();
        Collection<Integer> vorlesungen = vorl.keySet();

        final String insertSQL = "insert into pruefen (matrnr, vorlnr, persnr, note) values (?, ?, ?, ?)";
        final String checkSQL  = "select 1 from pruefen where matrnr = ? and vorlnr = ?";

        try (var insertStatement = conn.prepareStatement(insertSQL);
             var checkStatement  = conn.prepareStatement(checkSQL))
        {
            for (int trial = 0; trial < 20; trial++)
            {
                Integer matrnr = randomElement(rnd, studenten);
                Integer vorlnr = randomElement(rnd, vorlesungen);
                Integer persnr = gelesenVon.get(vorlnr);

                assert persnr != null;

                checkStatement.setInt(1, matrnr);
                checkStatement.setInt(2, vorlnr);

                try (var result = checkStatement.executeQuery())
                {
                    if (result.next()) {
                        trial--;
                        continue;
                    }
                }

                insertStatement.setInt(1, matrnr);
                insertStatement.setInt(2, vorlnr);
                insertStatement.setInt(3, persnr);
                insertStatement.setDouble(4, randomElement(rnd, noten));

                insertStatement.executeUpdate();
                insertStatement.close();
            }
        }
    }

    /**
     * @param rnd  ein Math.Random
     * @param coll eine Collection
     * @return ein zufälliges Element aus coll
     */
    private static <T> T randomElement(Random rnd, Collection<T> coll) {
        int i = 0;
        int which = rnd.nextInt(coll.size());
        for (T elem : coll) {
            if (i++ == which) {
                return elem;
            }
        }
        throw new IllegalStateException();
    }

    private static Map<Integer, String> readTable(Connection conn, String tab, String id, String label)
            throws SQLException {
        Map<Integer, String> map = new HashMap<>();
        try (var statement = conn.createStatement();
                var result = statement.executeQuery("select " + id + ", " + label + " from " + tab)) {
            while (result.next()) {
                map.put(result.getInt(1), result.getString(2));
            }
        }
        return map;
    }

    private static Map<Integer, Integer> readVorl(Connection conn) throws SQLException {
        Map<Integer, Integer> map = new HashMap<>();
        try (var statement = conn.createStatement();
             var result    = statement.executeQuery("select vorlnr, gelesenVon from vorlesungen")) 
        {
            while (result.next()) {
                map.put(result.getInt(1), result.getInt(2));
            }
        }
        return map;
    }
}
