public class Language implements Comparable<Language> {
    final private String name;

    public Language(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Language otherLanguage) {
        return this.getName().compareTo(otherLanguage.getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
