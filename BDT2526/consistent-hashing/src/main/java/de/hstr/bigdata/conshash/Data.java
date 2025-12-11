package de.hstr.bigdata.conshash;

import java.util.Objects;

/**
 * Repräsentiert einen Datensatz im Hash-Ring. Für unsere
 * Zwecke ist das nur der Schlüssel. In der Praxis würde sich dahinter
 * die komplette Zeile inklusive Wide Columns usw. verbergen.
 * 
 * @author schmi
 *
 */
public final class Data {
    private String key;

    public Data(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        return HashUtils.hashCode(key);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Data other = (Data) obj;
        return Objects.equals(key, other.getKey());
    }

    @Override
    public String toString() {
        return "Data(" + key + ")";
    }
}
