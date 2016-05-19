package entities;

public class Task {
    final public String name;
    final public String technology;

    /**
     * construtor da class Task
     * @param name_
     * @param technology_
     */
    public Task(String name_, String technology_) {
        this.name = name_;
        this.technology = technology_;
    }

    /**
     * metodo para obter o nome da task
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * metodo para obter a tecnologia necessaria para a task
     * @return technology
     */
    public String getTechnology() {
        return technology;
    }

    /**
     * colocar numa string de forma a aparecer na consola como pretendido
     * @return nameTask, technologies
     */
    @Override
    public String toString() {
        return this.name + "," + this.technology;
    }

    // Task is immutable, no setters, no need for new
    protected Task copy() {
        return this;
    }
}
