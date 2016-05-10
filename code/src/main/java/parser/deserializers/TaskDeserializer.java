package parser.deserializers;

import com.google.gson.*;
import entities.Task;

import java.lang.reflect.Type;

public class TaskDeserializer implements JsonDeserializer<Task> {

    @Override
    public Task deserialize(final JsonElement jsonElement, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = jsonElement.getAsJsonObject();

        // Get name
        String name = jsonObject.get("name").getAsString();

        // Get technology
        String technology = jsonObject.get("technology").getAsString();

        return new Task(name, technology);
    }
}
