package up.javafx.core.io;

import java.util.List;

public record Level(
        String name,
        int width,
        int height,
        int startX,
        int startY,
        List<CellDescriptor> cells
) {
    public static Level empty(String name, int width, int height) {
        return new Level(name, width, height, 1, 1, List.of());
    }
}
