package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Programmer implements Comparable<Programmer> {
    final private String name;
    final private HashSet<Language> languages;
    final private HashSet<Technology> technologies;
    final private int experience;
    final private double cost;

    /***
     * construtor da class Programmer
     * @param name
     * @param languages
     * @param technologies
     * @param experience
     */
    public Programmer(String name, HashSet<Language> languages, HashSet<Technology> technologies, int experience) {
        this.name = name;
        this.languages = languages;
        this.technologies = technologies;
        this.experience = experience;
        this.cost = CalculateCost();
    }

    /**
     * metodo para calcular o custo de cada programador
     * @return custo
     */
    private double CalculateCost() {
        return this.languages.size() + (this.technologies.size() * 0.75) + (this.experience * 0.25);
    }

    /**
     * metodo para obter o nome de cada trabalhador
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * metodo para obter o valor do custo de cada trabalhador
     * @return cost
     */
    public double getCost() {
        return this.cost;
    }

    /**
     * metodo para obter as linguagens que cada programador sabe
     * @return languages
     */
    public HashSet<Language> getLanguages() {
        return languages;
    }

    /**
     * metodo para obter as tecnologias dominadas por cada trabalhador
     * @return technologies
     */
    public HashSet<Technology> getTechnologies() {
        return technologies;
    }

    /**
     * metodo para obter a experiencia de cada programador
     * @return experience
     */
    public int getExperience() {
        return experience;
    }

    /**
     * meteodo para a verificacao se o programador sabe uma determinada linguagem
     * @param language
     * @return boolean
     */
    public boolean knowsLanguage(String language) {
        return this.languages.contains(language);
    }

    /**
     * meteodo para a verificacao se o programador sabe uma determinada tecnologia
     * @param technology
     * @return boolean
     */
    public boolean knowsTechnology(String technology) {
        return this.technologies.equals(technology);
    }

    /**
     * percorre o array de linguagens e de tecnologias e coloca as com '-' entre cada uma delas para apresentacao na consola.
     * mostra tambem o nome a experiencia e o custo.
     * @return lista separada por '-' de tecnologias e linguagens, name, experience, cost
     */
    @Override
    public String toString() {

        String languages_str = null;
        Iterator iterator = this.languages.iterator();
        if (iterator.hasNext()) {
            Language language = (Language) iterator.next();
            languages_str = language.toString();
            while (iterator.hasNext()) {
                language = (Language) iterator.next();
                languages_str += "-" + language.toString();
            }
        }

        String technologies_str = null;
        iterator = this.technologies.iterator();
        if (iterator.hasNext()) {
            Technology technology = (Technology) iterator.next();
            technologies_str = technology.toString();
            while (iterator.hasNext()) {
                technology = (Technology) iterator.next();
                languages_str += "-" + technology.toString();
            }
        }

        return this.name + "\t" + languages_str + "\t" + technologies_str + "\t" + this.experience + "\t" + this.cost;
    }

    /**
     * compara o custo de dois programadores
     * @param otherProgrammer
     * @return
     */
    @Override
    public int compareTo(Programmer otherProgrammer) {
        return Double.compare(this.getCost(), otherProgrammer.getCost());
    }

    /**
     * obtem o nome, as linguagens, as tecnologias e a experiencia de cada programador
     * @return name,languages,technologies,experience
     */
    public Programmer copy() {

        int languages_size = this.languages.size();
        HashSet<Language> languages_copy;
        if (languages_size != 0) {
            languages_copy = new HashSet<>(languages_size);
            this.languages.forEach(language -> languages_copy.add(language.copy()));
        } else {
            languages_copy = new HashSet<>();
        }

        int technologies_size = this.technologies.size();
        HashSet<Technology> technologies_copy;
        if (technologies_size != 0) {
            technologies_copy = new HashSet<>(technologies_size);
            this.technologies.forEach(technology -> technologies_copy.add(technology.copy()));
        } else {
            technologies_copy = new HashSet<>();
        }

        return new Programmer(this.name, languages_copy, technologies_copy, this.experience);
    }
}
