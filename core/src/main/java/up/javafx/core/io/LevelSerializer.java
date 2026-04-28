package up.javafx.core.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class LevelSerializer {

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    public static String toJson(Level level) throws IOException {
        return MAPPER.writeValueAsString(level);
    }

    public static Level fromJson(String json) throws IOException {
        return MAPPER.readValue(json, Level.class);
    }
}
