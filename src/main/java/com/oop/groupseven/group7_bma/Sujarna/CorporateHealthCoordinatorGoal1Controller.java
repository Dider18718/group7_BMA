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
public class CorporateHealthCoordinatorGoal1Controller {

    @javafx.fxml.FXML private TextField timeField;
    @javafx.fxml.FXML private ListView<String> servicesListView;   // typed generics
    @javafx.fxml.FXML private DatePicker datePicker;
    @javafx.fxml.FXML private Label confirmationLabel;
    @javafx.fxml.FXML private ComboBox<String> companyComboBox;    // typed generics

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String time    = (timeField != null) ? timeField.getText() : null;
        String date    = (datePicker != null && datePicker.getValue() != null)
                ? datePicker.getValue().toString() : null;
        String service = (servicesListView != null)
                ? servicesListView.getSelectionModel().getSelectedItem() : null;
        String company = (companyComboBox != null) ? companyComboBox.getValue() : null;

        // Removed unnecessary String.valueOf(...) calls
        String summary = String.format(
                "Saved: time=%s, date=%s, service=%s, company=%s",
                time, date, service, company
        );

        if (confirmationLabel != null) {
            confirmationLabel.setText(summary);
        }
        actionEvent.consume(); // keep param used
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    private void navigateToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    HelloApplication.class.getResource("Sujarna/CorporateHealthCoordinator.fxml"));
            Parent root = loader.load();
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
