package com.oop.groupseven.group7_bma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Choose which screen to start with:
        // -Dstart=driver  -> MedicalTransportDriverDashboard.fxml
        // anything else or unset -> CorporateHealthCoordinator.fxml
        String start = System.getProperty("start", "corporate").toLowerCase();

        String fxml = start.equals("driver")
                ? "Zainab/pharmacyOperatorDashboard.fxml"
                : "Zainab/doctorDashboard.fxml";


        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Parent root = loader.load();

        stage.setTitle("BMA");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
