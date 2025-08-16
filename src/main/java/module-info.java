module com.oop.groupseven.group7_bma {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;



    opens com.oop.groupseven.group7_bma to javafx.fxml;

    opens com.oop.groupseven.group7_bma.Sujarna to javafx.fxml, javafx.base ;
    opens com.oop.groupseven.group7_bma.Zainab to javafx.fxml, javafx.base ;
     opens com.oop.groupseven.group7_bma.Shibli to javafx.fxml, javafx.base ;
     opens com.oop.groupseven.group7_bma.Dider to javafx.fxml, javafx.base ;
    exports com.oop.groupseven.group7_bma;
    exports com.oop.groupseven.group7_bma.storage;
    opens com.oop.groupseven.group7_bma.storage to javafx.fxml;
}
