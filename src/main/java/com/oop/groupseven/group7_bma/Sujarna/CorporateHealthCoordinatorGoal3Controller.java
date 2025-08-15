package com.oop.groupseven.group7_bma.Sujarna;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class CorporateHealthCoordinatorGoal3Controller {

    @javafx.fxml.FXML private Label confirmationLabel;
    @javafx.fxml.FXML private ComboBox<String> companyComboBox;
    @javafx.fxml.FXML private ComboBox<String> eventComboBox;
    @javafx.fxml.FXML private Label uploadStatusLabel;

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String company = companyComboBox != null ? companyComboBox.getValue() : null;
        String event   = eventComboBox   != null ? eventComboBox.getValue()   : null;
        if (confirmationLabel != null) confirmationLabel.setText("Submitted: company=" + company + ", event=" + event);
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void attachButton(ActionEvent actionEvent) {
        if (uploadStatusLabel != null) uploadStatusLabel.setText("Attachment added");
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static final String BASE = "/com/oop/groupseven/group7_bma/Sujarna/";

    private void navigateToDashboard(ActionEvent event) {
        java.net.URL url = this.getClass().getResource(BASE + "CorporateHealthCoordinator.fxml");
        if (url == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Missing FXML");
            a.setContentText("Could not find resource: " + BASE + "CorporateHealthCoordinator.fxml" + System.lineSeparator()
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
