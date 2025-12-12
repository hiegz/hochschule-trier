package de.hstr.bigdata.conshash;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

class VirtualHashRingImpl implements HashRing {
    private final NavigableMap<Integer, Node> ring = new TreeMap<>();

    public VirtualHashRingImpl(Set<String> hosts, int virtualsPerNode) {
        for (String hostname : hosts) {
            for (int i = 1; i <= virtualsPerNode; i++) {
                Node node = new Node(hostname);
                String virtual = hostname + "-" + i;
                int hash = HashUtils.hashCode(virtual);
                if (ring.containsKey(hash)) {
                    throw new IllegalArgumentException(
                            "Hash-Kollision zwischen Knoten: " + node + " und " + ring.get(hash));
                }
                ring.put(hash, node);
            }
        }
    }

    @Override
    public Set<Node> getNodes() {
        return Set.copyOf(ring.values());
    }

    @Override
    public Node placeData(Data data) {
        int h = data.hashCode();
        Map.Entry<Integer, Node> e = ring.ceilingEntry(h);
        if (e == null) {
            e = ring.firstEntry();
        }
        return e.getValue();
    }
}
