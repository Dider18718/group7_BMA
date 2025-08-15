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

public class CorporateHealthCoordinatorGoal1Controller {

    @javafx.fxml.FXML
    private TextField timeField;
    @javafx.fxml.FXML
    private ListView<String> servicesListView;
    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private ComboBox<String> companyComboBox;

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String time = timeField != null ? timeField.getText() : null;
        String company = companyComboBox != null ? companyComboBox.getValue() : null;
        String service = (servicesListView != null && !servicesListView.getSelectionModel().isEmpty())
                ? servicesListView.getSelectionModel().getSelectedItem()
                : null;
        String date = (datePicker != null && datePicker.getValue() != null) ? datePicker.getValue().toString() : null;

        if (confirmationLabel != null) {
            String msg = "Saved: time=" + time + ", date=" + date + ", company=" + company + ", service=" + service;
            confirmationLabel.setText(msg);
        }

        // Mark handled and avoid 'unused parameter' warnings
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static final String BASE = "/com/oop/groupseven/group7_bma/Sujarna/";

    private void navigateToDashboard(ActionEvent event) {
        URL url = this.getClass().getResource(BASE + "CorporateHealthCoordinator.fxml");
        if (url == null) {
            showError("Missing FXML",
                    "Could not find resource: " + BASE + "CorporateHealthCoordinator.fxml" + System.lineSeparator()
                            + "Make sure it is on the runtime classpath under src/main/resources");
            return;
        }
        try {
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showError("Navigation Error", e.getMessage());
        }
    }

    private void showError(String header, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
