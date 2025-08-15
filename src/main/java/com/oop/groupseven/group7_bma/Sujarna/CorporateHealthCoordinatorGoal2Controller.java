package com.oop.groupseven.group7_bma.Sujarna;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class CorporateHealthCoordinatorGoal2Controller {

    @javafx.fxml.FXML private ComboBox<String> staffComboBox;
    @javafx.fxml.FXML private ComboBox<String> roleComboBox;
    @javafx.fxml.FXML private Label confirmationLabel;
    @javafx.fxml.FXML private ListView<String> assignedListView;
    @javafx.fxml.FXML private ComboBox<String> eventComboBox;

    @javafx.fxml.FXML
    public void assignButton(ActionEvent actionEvent) {
        String staff = staffComboBox != null ? staffComboBox.getValue() : null;
        String role  = roleComboBox  != null ? roleComboBox.getValue()  : null;
        String event = eventComboBox != null ? eventComboBox.getValue() : null;

        String summary = "Assigned: staff=" + staff + ", role=" + role + ", event=" + event;
        if (assignedListView != null) assignedListView.getItems().add(summary);
        if (confirmationLabel != null) confirmationLabel.setText(summary);
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
