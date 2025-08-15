package com.oop.groupseven.group7_bma.Sujarna;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class MedicalTransportDriverGoal3Controller {

    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private ComboBox<String> vehicleComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> issueTypeComboBox;
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private TextArea issueTextArea;

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String vehicle = vehicleComboBox != null ? vehicleComboBox.getValue() : null;
        String issueType = issueTypeComboBox != null ? issueTypeComboBox.getValue() : null;
        String title = titleTextField != null ? titleTextField.getText() : null;
        String details = issueTextArea != null ? issueTextArea.getText() : null;

        if (confirmationLabel != null) {
            String msg = "Issue filed"
                    + (vehicle != null ? " • vehicle=" + vehicle : "")
                    + (issueType != null ? " • type=" + issueType : "")
                    + (title != null && !title.isBlank() ? " • title=" + title : "")
                    + (details != null && !details.isBlank() ? " • details added" : "");
            confirmationLabel.setText(msg);
        }

        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static final String BASE = "/com/oop/groupseven/group7_bma/Sujarna/";

    private void navigateToDashboard(ActionEvent event) {
        URL url = this.getClass().getResource(BASE + "MedicalTransportDriverDashboard.fxml");
        if (url == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Missing FXML");
            a.setContentText("Could not find resource: " + BASE + "MedicalTransportDriverDashboard.fxml" + System.lineSeparator()
                    + "Make sure it is on the classpath under src/main/resources");
            a.showAndWait();
            return;
        }
        try {
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Navigation Error");
            a.setContentText(e.getMessage());
            a.showAndWait();
        }
    }
}
