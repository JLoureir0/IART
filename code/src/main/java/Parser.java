import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Parser {

    public ParsedData parse(String filepath) throws Exception {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Programmer.class, new ProgrammerDeserializer());
        gsonBuilder.registerTypeAdapter(Module.class, new ModuleDeserializer());
        gsonBuilder.registerTypeAdapter(Task.class, new TaskDeserializer());
        Gson gson = gsonBuilder.create();

        JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filepath), "UTF-8"));

        JsonParser jsonParser = new JsonParser();
        JsonObject json_global_object = jsonParser.parse(jsonReader).getAsJsonObject();

        Type PriorityQueueProgrammerType = new TypeToken<PriorityQueue<Programmer>>() {
        }.getType();
        PriorityQueue<Programmer> programmers = gson.fromJson(json_global_object.get("programmers"), PriorityQueueProgrammerType);

        Type ArrayListType = new TypeToken<ArrayList<Module>>() {
        }.getType();
        ArrayList<Module> modules = gson.fromJson(json_global_object.get("modules"), ArrayListType);

        return new ParsedData(programmers, modules);
    }
}
