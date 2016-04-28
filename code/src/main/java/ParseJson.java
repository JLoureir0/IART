import java.io.FileReader;
import java.util.PriorityQueue;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ParseJson {

    public PriorityQueue<Programmer> programmers = new PriorityQueue<Programmer>();

    public void parse(String filepath) {

        JSONParser jsonParser = new JSONParser();

        try {

            JSONObject global_json_object = (JSONObject) jsonParser.parse(new FileReader(filepath));

            JSONArray programmers_json_array = (JSONArray) global_json_object.get("programmers");

            for (Object programmer_object : programmers_json_array) {
                JSONObject programmer_json_object = (JSONObject) programmer_object;
                // Get name
                String name = (String) programmer_json_object.get("name");

                // Get technologies
                JSONArray technologies_json_array = (JSONArray) programmer_json_object.get("technologies");
                TreeSet<Technology> technologies = new TreeSet<Technology>();
                for (Object technology_object : technologies_json_array) {
                    JSONObject technology_json_object = (JSONObject) technology_object;
                    technologies.add(new Technology((String)technology_json_object.get("name")));
                }

                // Get Languages
                JSONArray languages_json_array = (JSONArray) programmer_json_object.get("languages");
                TreeSet<Language> languages = new TreeSet<Language>();
                for (Object language_object : languages_json_array) {
                    JSONObject language_json_object = (JSONObject) language_object;
                    languages.add(new Language((String)language_json_object.get("name")));
                }

                // Get Experience
                int experience = (int) programmer_json_object.get("experience");

                this.programmers.add(new Programmer(name, languages, technologies, experience));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
