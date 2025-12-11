package de.hstr.bigdata.conshash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VirtualDistributionTest {
    public static void main(String[] args) {
        int numHosts = 10;
        int numDaten = 1024 * 1024;

        Set<String> hosts = new HashSet<>();
        for (int i = 0; i < numHosts; ++i) {
            hosts.add("host" + i);
        }

        HashRing hashRing = new VirtualHashRingImpl(hosts, 100);
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < numDaten; ++i) {
            Data data = new Data("data" + i);
            Node host = hashRing.placeData(data);
            counts.merge(host.getHostname(), 1, Integer::sum);
        }

        counts.forEach((host, count) -> System.out.println(host + ": " + count));
    }
}
