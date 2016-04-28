import java.io.FileReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeSet;

import com.google.gson.*;

public class ParseJson {

    public PriorityQueue<Programmer> programmers = new PriorityQueue<Programmer>();

    public void parse(String filepath) {

        JsonElement jsonParser = new JsonParser().parse(filepath);
        JsonObject global_json_object = jsonParser.getAsJsonObject();

        try {

            JsonArray programmers_json_array = global_json_object.getAsJsonArray("programmers");

            Iterator it = programmers_json_array.iterator();
            while (it.hasNext()) {
                JsonObject programmer_json_object = (JsonObject) it.next();
                // Get name
                String name = programmer_json_object.get("name").getAsString();

                // Get technologies
                JsonArray technologies_json_array = programmer_json_object.getAsJsonArray("technologies");
                it = technologies_json_array.iterator();
                TreeSet<Technology> technologies = new TreeSet<Technology>();
                while (it.hasNext()) {
                    JsonObject technology_json_object = (JsonObject) it.next();
                    technologies.add(new Technology(technology_json_object.get("name").getAsString()));
                }

                // Get Languages
                JsonArray languages_json_array = (JsonArray) programmer_json_object.get("languages");
                it = languages_json_array.iterator();
                TreeSet<Language> languages = new TreeSet<Language>();
                while (it.hasNext()) {
                    JsonObject language_json_object = (JsonObject) it.next();
                    languages.add(new Language(language_json_object.get("name").getAsString()));
                }

                // Get Experience
                int experience = programmer_json_object.get("experience").getAsInt();

                this.programmers.add(new Programmer(name, languages, technologies, experience));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
