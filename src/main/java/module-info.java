module com.oop.groupseven.group7_bma {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;   // if you use charts/canvas/etc.
    requires java.desktop;      // FileChooser, Desktop, etc.
    requires java.logging;      // for BinStorage logging

    // ---- public API exports ----
    exports com.oop.groupseven.group7_bma;

    // feature packages
    exports com.oop.groupseven.group7_bma.Sujarna;
    exports com.oop.groupseven.group7_bma.Zainab;
    exports com.oop.groupseven.group7_bma.Shibli;
    exports com.oop.groupseven.group7_bma.Dider;

    // utilities
    exports com.oop.groupseven.group7_bma.storage;

    // ---- FXML reflection access ----
    opens com.oop.groupseven.group7_bma to javafx.fxml;
    opens com.oop.groupseven.group7_bma.Sujarna to javafx.fxml, javafx.base;
    opens com.oop.groupseven.group7_bma.Zainab  to javafx.fxml, javafx.base;
    opens com.oop.groupseven.group7_bma.Shibli  to javafx.fxml, javafx.base;
    opens com.oop.groupseven.group7_bma.Dider   to javafx.fxml, javafx.base;

    // open storage only if you actually load FXML from there (usually not needed)
    // opens com.oop.groupseven.group7_bma.storage to javafx.fxml;
}
