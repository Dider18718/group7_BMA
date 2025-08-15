package com.oop.groupseven.group7_bma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SuppressWarnings("SpellCheckingInspection")
public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // -Dstart=driver -> transport; otherwise corporate
        String start = System.getProperty("start", "corporate").toLowerCase();

        String fxml = start.equals("driver")
                ? "Sujarna/MedicalTransportDriverDashboard.fxml"
                : "Sujarna/CorporateHealthCoordinator.fxml";

        Parent root = FXMLLoader.load(HelloApplication.class.getResource(fxml));
        stage.setTitle("BMA");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
