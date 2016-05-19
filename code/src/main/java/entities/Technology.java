package entities;

public class Technology implements Comparable<Technology> {
    final private String name;

    /**
     * construtor da class Technology
     * @param name nome
     */
    public Technology(String name) {
        this.name = name;
    }

    /**
     * metodo para obter o nome da tecnologia
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * metodo para comparar as tecnologias
     * @param technology
     * @return
     */
    @Override
    public int compareTo(Technology technology) {
        return this.getName().compareTo(technology.getName());
    }

    /**
     * conversao para string
     * @return name
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        Technology otherTechnology = (Technology) obj;
        return this.getName().equals(otherTechnology.getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    // Technology is immutable, no setters, no need for new
    protected Technology copy() {
        return this;
    }
}
