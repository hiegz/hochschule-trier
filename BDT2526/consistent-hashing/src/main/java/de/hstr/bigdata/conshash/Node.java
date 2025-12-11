package de.hstr.bigdata.conshash;

import java.util.Objects;

/**
 * Repräsentiert einen Knoten im Hash-Ring. Für unsere
 * Zwecke ist das im Wesentlichen ein String (der Hostname),
 * in Wirklichkeit wären hier IP-Adressen, virtuelle Knoten
 * usw. verzeichnet.
 * 
 * @author schmi
 *
 */
public final class Node {
    private String hostname;

    public Node(String hostname) {
        this.hostname = hostname;
    }

    public String getHostname() {
        return hostname;
    }

    @Override
    public int hashCode() {
        return HashUtils.hashCode(hostname);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        return Objects.equals(hostname, other.getHostname());
    }

    @Override
    public String toString() {
        return "Node(" + hostname + ")";
    }
}
