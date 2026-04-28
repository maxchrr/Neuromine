package up.javafx.editor.dto;

import up.javafx.core.io.Level;
import up.javafx.editor.model.EditorState;

public record EditorSnapshot(
        Level       level,
        EditorState currentTool,
        boolean     hasUnsavedChanges
) {}
