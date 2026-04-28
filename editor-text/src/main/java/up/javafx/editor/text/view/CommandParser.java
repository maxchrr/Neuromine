package up.javafx.editor.text.view;

public class CommandParser {

    public static EditorCommand parse(String line) {
        if (line == null || line.isBlank()) return EditorCommand.UNKNOWN;
        return switch (line.trim().split("\\s+")[0].toLowerCase()) {
            case "place"          -> EditorCommand.PLACE;
            case "erase"          -> EditorCommand.ERASE;
            case "new", "resize"  -> EditorCommand.RESIZE;
            case "save"           -> EditorCommand.SAVE;
            case "load"           -> EditorCommand.LOAD;
            case "quit", "exit"   -> EditorCommand.QUIT;
            default               -> EditorCommand.UNKNOWN;
        };
    }
}
