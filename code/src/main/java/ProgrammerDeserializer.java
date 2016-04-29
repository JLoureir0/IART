import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.TreeSet;

public class ProgrammerDeserializer implements JsonDeserializer<Programmer> {

    @Override
    public Programmer deserialize(final JsonElement jsonElement, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = jsonElement.getAsJsonObject();

        // Get name
        String name = jsonObject.get("name").getAsString();

        // Get technologies
        JsonArray json_technologies_array = jsonObject.get("technologies").getAsJsonArray();
        TreeSet<Technology> technologies = new TreeSet<>();
        for (JsonElement json_technology_element : json_technologies_array) {
            technologies.add(new Technology(json_technology_element.getAsString()));
        }

        // Get Languages
        JsonArray json_languages_array = jsonObject.get("languages").getAsJsonArray();
        TreeSet<Language> languages = new TreeSet<>();
        for (JsonElement json_language_element : json_languages_array) {
            languages.add(new Language(json_language_element.getAsString()));
        }

        // Get Experience
        int experience = jsonObject.get("experience").getAsInt();

        return new Programmer(name, languages, technologies, experience);
    }
}
