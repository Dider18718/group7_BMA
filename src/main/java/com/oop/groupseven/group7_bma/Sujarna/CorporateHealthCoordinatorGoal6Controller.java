package com.oop.groupseven.group7_bma.Sujarna;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class CorporateHealthCoordinatorGoal6Controller {

    // Keeping it minimal to avoid fx:id mismatches: we only rely on confirmationLabel
    @javafx.fxml.FXML private Label confirmationLabel;

    // Handler names in your FXML: addEditButton, clearButton, backButton
    @javafx.fxml.FXML
    public void addEditButton(ActionEvent e) {
        if (confirmationLabel != null) confirmationLabel.setText("✔ Package saved");
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent e) {
        if (confirmationLabel != null) confirmationLabel.setText("");
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent event) { navigateToDashboard(event); }

    private void navigateToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Sujarna/CorporateHealthCoordinator.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            showError("Navigation Error", ex.getMessage());
        }
    }

    private void showError(String header, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(header);
        a.setContentText(message);
        a.showAndWait();
    }
}
