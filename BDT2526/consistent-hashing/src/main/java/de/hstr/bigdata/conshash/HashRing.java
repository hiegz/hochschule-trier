package de.hstr.bigdata.conshash;

import java.util.Set;

/**
 * Repräsentiert einen Hash-Ring für Consistent Hashing.
 * 
 * @author schmi
 *
 */
public interface HashRing {
    /**
     * @return die Liste aller Knoten im Ring
     */
    Set<Node> getNodes();
    
    /**
     * @param data ein Datensatz
     * @return der Knoten, auf den der Datensatz platziert wird
     */
    Node placeData (Data data);
}
