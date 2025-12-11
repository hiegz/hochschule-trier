package de.hstr.bigdata.conshash;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class HashRingImpl implements HashRing {
    private final NavigableMap<Integer, Node> ring = new TreeMap<>();

    public HashRingImpl(Set<String> hosts) throws IllegalArgumentException {
        if (hosts == null || hosts.isEmpty()) {
            throw new IllegalArgumentException("Knotenmenge darf nicht leer sein");
        }

        for (String hostname : hosts) {
            Node node = new Node(hostname);
            int hash = node.hashCode();
            if (ring.containsKey(hash)) {
                throw new IllegalArgumentException(
                        "Hash-Kollision zwischen Knoten: " + node + " und " + ring.get(hash));
            }
            ring.put(hash, node);
        }
    }

    @Override
    public Set<Node> getNodes() {
        return Set.copyOf(ring.values());
    }

    @Override
    public Node placeData(Data data) {
        Map.Entry<Integer, Node> entry = ring.ceilingEntry(data.hashCode());

        if (entry == null) {
            return ring.firstEntry().getValue();
        }

        return entry.getValue();
    }
}
