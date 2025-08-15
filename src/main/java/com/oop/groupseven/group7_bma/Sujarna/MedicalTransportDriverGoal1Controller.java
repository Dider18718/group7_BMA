package com.oop.groupseven.group7_bma.Sujarna;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

@SuppressWarnings({ "SpellCheckingInspection", "CanBeFinal" })
public class MedicalTransportDriverGoal1Controller {

    @javafx.fxml.FXML private Label statusLabel = new Label();

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        if (statusLabel != null) statusLabel.setText("Ride scheduled");
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    private void navigateToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(HelloApplication.class.getResource("Sujarna/MedicalTransportDriverDashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root)); stage.show();
        } catch (IOException e) {
            showError("Navigation Error", e.getMessage());
        }
    }

    private void showError(String h, String m) {
        Alert a = new Alert(Alert.AlertType.ERROR); a.setTitle("Error"); a.setHeaderText(h); a.setContentText(m); a.showAndWait();
    }
}
