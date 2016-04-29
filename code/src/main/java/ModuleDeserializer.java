import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ModuleDeserializer implements JsonDeserializer<Module> {

    @Override
    public Module deserialize(final JsonElement jsonElement, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = jsonElement.getAsJsonObject();

        // Get name
        String name = jsonObject.get("name").getAsString();

        // Get Tasks
        Type ArrayListTaskType = new TypeToken<ArrayList<Task>>() {
        }.getType();
        ArrayList<Task> tasks = context.deserialize(jsonObject.get("tasks"), ArrayListTaskType);

        return new Module(name, tasks);
    }
}