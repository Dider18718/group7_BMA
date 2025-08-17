package com.oop.groupseven.group7_bma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // VM option: -Dstart=<key>
        // Keys supported (case-insensitive):
        //   corporate
        //   driver
        //   zainab-doctor, zainab-pharmacy
        //   shibli-patient, shibli-inspector
        //   dider-admin, dider-support
        String start = System.getProperty("start", "corporate").trim().toLowerCase();

        String fxmlPath = switch (start) {
            // Sujarna
            case "driver"            -> "Sujarna/MedicalTransportDriverDashboard.fxml";
            case "corporate"         -> "Sujarna/CorporateHealthCoordinator.fxml";

            // Zainab
            case "zainab-doctor"     -> "Zainab/doctorDashboard.fxml";
            case "zainab-pharmacy"   -> "Zainab/pharmacyOperatorDashboard.fxml";

            // Shibli
            case "shibli-patient"    -> "Shibli/PatientDashboardView.fxml";
            case "shibli-inspector"  -> "Shibli/MedicalInspectorDashboard.fxml";

            // Dider
            case "dider-admin"       -> "Dider/hospitalAdministrator.fxml";
            case "dider-support"     -> "Dider/PatientSupport.fxml";

            // Fallback -> corporate
            default -> "Sujarna/CorporateHealthCoordinator.fxml";
        };

        URL url = HelloApplication.class.getResource(fxmlPath);
        if (url == null) {
            throw new IllegalStateException("FXML not found: " + fxmlPath +
                    " (place it under src/main/resources/" + fxmlPath + ")");
        }

        Parent root = FXMLLoader.load(url);
        stage.setTitle("BMA");
        stage.setScene(new Scene(root));
        stage.show();
        System.out.println("[BMA] Started with -Dstart=" + start + " using " + fxmlPath);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
