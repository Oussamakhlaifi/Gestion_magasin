module com.example.gestionstock {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;

    opens com.example.gestionstock to javafx.fxml;
    exports com.example.gestionstock;
}