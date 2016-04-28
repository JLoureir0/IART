import java.util.TreeSet;

public class Programmer {
    final private String name;
    final private TreeSet<Language> languages;
    final private TreeSet<Technology> technologies;
    final private int experience;

    public Programmer(String name, TreeSet<Language> languages, TreeSet<Technology> technologies, int experience) {
        this.name = name;
        this.languages = languages;
        this.technologies = technologies;
        this.experience = experience;
    }

    public boolean knowsLanguage(Language language) {
        return this.languages.contains(language);
    }

    public boolean knowsTechnology(Technology technology) {
        return this.technologies.contains(technology);
    }

    public String toString() {
        String languages = null;
        for (Language language : this.languages) {
            languages += language.getName();
        }
        String technologies = null;
        for (Technology technology : this.technologies) {
            technologies += technology.getName();
        }

        return this.name + ":" + this.languages + ":" + this.technologies + ":" + this.experience;
    }
}
