package up.javafx.core.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LevelRepository {

    public static Level load(Path path) throws LevelIOException {
        try {
            return LevelSerializer.fromJson(Files.readString(path));
        } catch (IOException e) {
            throw new LevelIOException("Cannot load level: " + path, e);
        }
    }

    public static void save(Level level, Path path) throws LevelIOException {
        try {
            Files.writeString(path, LevelSerializer.toJson(level));
        } catch (IOException e) {
            throw new LevelIOException("Cannot save level: " + path, e);
        }
    }
}
