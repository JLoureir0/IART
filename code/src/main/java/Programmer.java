import java.util.Iterator;
import java.util.TreeSet;

public class Programmer implements Comparable<Programmer> {
    final private String name;
    final private TreeSet<Language> languages;
    final private TreeSet<Technology> technologies;
    final private int experience;
    final private double cost;

    public Programmer(String name, TreeSet<Language> languages, TreeSet<Technology> technologies, int experience) {
        this.name = name;
        this.languages = languages;
        this.technologies = technologies;
        this.experience = experience;
        this.cost = CalculateCost();
    }

    private double CalculateCost() {
        return this.languages.size() + this.technologies.size() * 0.75 + this.experience * 0.25;
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    public TreeSet<Language> getLanguages() {
        return languages;
    }

    public TreeSet<Technology> getTechnologies() {
        return technologies;
    }

    public int getExperience() {
        return experience;
    }

    public boolean knowsLanguage(Language language) {
        return this.languages.contains(language);
    }

    public boolean knowsTechnology(Technology technology) {
        return this.technologies.contains(technology);
    }

    @Override
    public String toString() {

        String languages_str = null;
        Iterator iterator = this.languages.iterator();
        if (iterator.hasNext()) {
            Language language = (Language) iterator.next();
            languages_str = language.getName();
            while (iterator.hasNext()) {
                language = (Language) iterator.next();
                languages_str += "-" + language.getName();
            }
        }

        String technologies_str = null;
        iterator = this.technologies.iterator();
        if (iterator.hasNext()) {
            Technology technology = (Technology) iterator.next();
            technologies_str = technology.getName();
            while (iterator.hasNext()) {
                technology = (Technology) iterator.next();
                languages_str += "-" + technology.getName();
            }
        }

        return this.name + "\t" + languages_str + "\t" + technologies_str + "\t" + this.experience + "\t" + this.cost;
    }

    @Override
    public int compareTo(Programmer otherProgrammer) {
        return Double.compare(this.getCost(), otherProgrammer.getCost());
    }
}
