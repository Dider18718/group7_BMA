module com.oop.groupseven.group7_bma {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.oop.groupseven.group7_bma to javafx.fxml;
    exports com.oop.groupseven.group7_bma;
}