import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Stream;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        Package a = new Package("A");
        Package b = new Package("B");
        Package c = new Package("C");
        Package d = new Package("D");

        a.dependencies.add(b);
        b.dependencies.add(c);
        c.dependencies.add(d);
        d.dependencies.add(a);

        List<Path> cycles = new ArrayList<Path>();

        cycles.addAll(Packages.findCycles(a));
        cycles.addAll(Packages.findCycles(b));
        cycles.addAll(Packages.findCycles(c));
        cycles.addAll(Packages.findCycles(d));

        for (var cycle : cycles) {
            System.out.println(cycle.toString());
        }
    }
}

class Package {
    public String name;
    public Set<Package> dependencies;

    public Package(String name) {
        this.name = name;
        this.dependencies = new HashSet<>();
    }
}

class Path {
    public List<Package> packages;

    public Path(List<Package> packages) {
        this.packages = packages;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0, size = packages.size(), last = size - 1; i < size; ++i) {
            s += packages.get(i).name;
            if (i != last) {
                s += " -> ";
            }
        }
        return s;
    }
}

class Paths {
    public static Path concat(Path a, Path b) {
        return new Path(Stream.concat(a.packages.stream(), b.packages.stream()).toList());
    }
}

class Packages {
    public static List<Path> findCycles(Package p) {
        return findCyclesInternal(p, p, new HashSet<>());
    }

    private static List<Path> findCyclesInternal(Package current, Package origin, Set<Package> visited) {
        List<Path> cycles = new ArrayList<>();
        Path path = new Path(Arrays.asList(current));

        if (visited.contains(current)) {
            if (current == origin)
                return Arrays.asList(path);

            return new ArrayList<Path>();
        }

        visited.add(current);

        for (var dependency : current.dependencies) {
            var paths = findCyclesInternal(dependency, origin, new HashSet<>(visited));
            for (var rest : paths) {
                if (rest.packages.size() == 0)
                    continue;
                cycles.add(Paths.concat(path, rest));
            }
        }

        return cycles;
    }
}
