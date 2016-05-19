package entities;

public class Language implements Comparable<Language> {
    final private String name;

    /**
     * construtor da class Language
     * @param name
     */
    public Language(String name) {
        this.name = name;
    }

    /**
     * metodo para obter o nome de uma linguagem
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * compara os nomes da liguangem
     * @param otherLanguage
     * @return 0 se as duas strings sao iguais lexicalmente; um valor menor que 0 se a primeira string for maior que a segunda;
     * um valor maior que 0 se a primeira string for menor que a segunda
     */
    @Override
    public int compareTo(Language otherLanguage) {
        return this.getName().compareTo(otherLanguage.getName());
    }

    /**
     * converte o nome numa string
     * @return name
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * compara uma linguagem com a linguagem do objeto
     * @param obj
     * @return nome da linguagem
     */
    @Override
    public boolean equals(Object obj) {
        Language otherLanguage = (Language) obj;
        return this.getName().equals(otherLanguage.getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    // Language is immutable, no setters, no need for new
    protected Language copy() {
        return this;
    }
}
