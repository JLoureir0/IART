package entities;

public class Task {
    final public String name;
    final public String technology;

    public Task(String name_, String technology_) {
        this.name = name_;
        this.technology = technology_;
    }

    public String getName() {
        return name;
    }

    public String getTechnology() {
        return technology;
    }

    @Override
    public String toString() {
        return this.name + "," + this.technology;
    }

    // Task is immutable, no setters, no need for new
    protected Task copy() {
        return this;
    }
}
