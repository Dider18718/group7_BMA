package com.oop.groupseven.group7_bma.Sujarna;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class MedicalTransportDriverDashboardController {

    @javafx.fxml.FXML
    public void transportScheduleButton(ActionEvent event) {
        gotoView(event, "Sujarna/MedicalTransportDriverGoal1.fxml");
    }

    @javafx.fxml.FXML
    public void tripStatusButton(ActionEvent event) {
        gotoView(event, "Sujarna/MedicalTransportDriverGoal2.fxml");
    }

    @javafx.fxml.FXML
    public void reportIssueButton(ActionEvent event) {
        gotoView(event, "Sujarna/MedicalTransportDriverGoal3.fxml");
    }

    @javafx.fxml.FXML
    public void checkMapButton(ActionEvent event) {
        gotoView(event, "Sujarna/MedicalTransportDriverGoal6.fxml");
    }

    @javafx.fxml.FXML
    public void endofDayButton(ActionEvent event) {
        gotoView(event, "Sujarna/MedicalTransportDriverGoal7.fxml");
    }

    @javafx.fxml.FXML
    public void vehicleButton(ActionEvent event) {
        // NOTE: your FXML filename includes a space before .fxml; kept as-is.
        gotoView(event, "Sujarna/MedicalTransportDriverGoal8 .fxml");
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent event) {
        event.consume(); // mark parameter used
        javafx.application.Platform.exit();
    }

    // --- helpers ---
    private void gotoView(ActionEvent event, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showError("Navigation Error", e.getMessage());
        }
    }

    @SuppressWarnings("SameParameterValue")
    private void showError(String header, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(header);
        a.setContentText(message);
        a.showAndWait();
    }
}
