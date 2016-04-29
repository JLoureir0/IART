public class Technology implements Comparable<Technology> {
    final private String name;

    public Technology(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Technology technology) {
        return this.getName().compareTo(technology.getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
