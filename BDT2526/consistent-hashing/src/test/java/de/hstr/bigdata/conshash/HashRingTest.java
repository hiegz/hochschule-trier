package de.hstr.bigdata.conshash;

import java.util.HashSet;
import java.util.Set;

/**
 * Kein Unit-Test, lediglich eine Klasse zum Herumspielen.
 * 
 * @author schmi
 */
public class HashRingTest {
    public static void main(String[] args) {
        int numHosts = 10;
        int numData = 100;

        Set<String> hosts = new HashSet<>();
        for (int i = 0; i < numHosts; i++) {
            hosts.add("host" + i);
        }
        HashRingImpl ring = new HashRingImpl(hosts);

        for (int j = 0; j < numData; j++) {
            Data data = new Data("data" + j);
            Node host = ring.placeData(data);
            System.err.println(data + " -> " + host);
        }
    }
}
