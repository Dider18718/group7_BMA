package com.oop.groupseven.group7_bma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    /** All FXMLs live under this classpath base. */
    public static final String BASE = "/com/oop/groupseven/group7_bma/";

    /** Load an FXML (relative to BASE) and return the root node. */
    public static Parent load(String relativePath) throws IOException {
        String rel = relativePath.startsWith("/") ? relativePath.substring(1) : relativePath;
        var url = HelloApplication.class.getResource(BASE + rel);
        if (url == null) {
            throw new IOException("FXML not found: " + BASE + rel +
                    "\nPlace it under src/main/resources" + BASE + rel);
        }
        return new FXMLLoader(url).load();
    }

    /** Switch the current window (from any control) to an FXML scene. */
    public static void switchScene(Node source, String relativePath) {
        try {
            Parent root = load(relativePath);
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Navigation Error");
            a.setHeaderText("Failed to open view");
            a.setContentText(ex.getMessage());
            a.showAndWait();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        // optional: -Dstart=driver / corporate / shibli-patient / etc.
        String start = System.getProperty("start", "").trim().toLowerCase();

        String fxml = switch (start) {
            case "driver"           -> "Sujarna/MedicalTransportDriverDashboard.fxml";
            case "corporate"        -> "Sujarna/CorporateHealthCoordinator.fxml";
            case "zainab-doctor"    -> "Zainab/doctorDashboard.fxml";
            case "zainab-pharmacy"  -> "Zainab/pharmacyOperatorDashboard.fxml";
            case "shibli-patient"   -> "Shibli/PatientDashboardView.fxml";
            case "shibli-inspector" -> "Shibli/MedicalInspectorDashboard.fxml";
            case "dider-admin"      -> "Dider/hospitalAdministrator.fxml";
            case "dider-support"    -> "Dider/PatientSupport.fxml";
            default                 -> "AppLauncher.fxml";
        };

        stage.setTitle("BMA");
        stage.setScene(new Scene(load(fxml)));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
