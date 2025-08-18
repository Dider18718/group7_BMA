module com.oop.groupseven.group7_bma {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires java.logging;

    // public APIs
    exports com.oop.groupseven.group7_bma;
    exports com.oop.groupseven.group7_bma.Sujarna;
    exports com.oop.groupseven.group7_bma.Zainab;
    exports com.oop.groupseven.group7_bma.Shibli;
    exports com.oop.groupseven.group7_bma.Dider;
    exports com.oop.groupseven.group7_bma.storage;

    // reflection for FXML
    opens com.oop.groupseven.group7_bma to javafx.fxml;
    opens com.oop.groupseven.group7_bma.Sujarna to javafx.fxml, javafx.base;
    opens com.oop.groupseven.group7_bma.Zainab  to javafx.fxml, javafx.base;
    opens com.oop.groupseven.group7_bma.Shibli  to javafx.fxml, javafx.base;
    opens com.oop.groupseven.group7_bma.Dider   to javafx.fxml, javafx.base;
}
