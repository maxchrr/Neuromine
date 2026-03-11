module up.javafx.game {
    requires javafx.controls;
    requires transitive javafx.graphics;

    requires up.javafx.mvc;

    opens up.javafx.neuromine to javafx.graphics;

    exports up.javafx.neuromine;
}
