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

public class CorporateHealthCoordinatorGoal7Controller {

    @javafx.fxml.FXML
    private Label rateLabel;
    @javafx.fxml.FXML
    private TextField attendanceTextField;
    @javafx.fxml.FXML
    private Label employedLabel;
    @javafx.fxml.FXML
    private ComboBox<String> eventComboBox;

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String attendanceStr = attendanceTextField != null ? attendanceTextField.getText() : null;
        int attendance;
        try {
            attendance = attendanceStr != null && !attendanceStr.isBlank()
                    ? Integer.parseInt(attendanceStr.trim())
                    : 0;
        } catch (NumberFormatException e) {
            showError("Invalid input", "Attendance must be a number.");
            actionEvent.consume();
            return;
        }

        // Extract digits from employedLabel text
        int employed;
        if (employedLabel != null && employedLabel.getText() != null) {
            String txt = employedLabel.getText();
            StringBuilder digits = new StringBuilder();
            for (int i = 0; i < txt.length(); i++) {
                char c = txt.charAt(i);
                if (Character.isDigit(c)) digits.append(c);
            }
            String ds = digits.toString();
            if (!ds.isEmpty()) {
                try { employed = Integer.parseInt(ds); }
                catch (NumberFormatException ex) { employed = 100; }
            } else {
                employed = 100;
            }
        } else {
            employed = 100;
        }

        double rate = employed > 0 ? (attendance * 100.0) / employed : 0.0;
        String selectedEvent = eventComboBox != null ? eventComboBox.getValue() : null;

        if (rateLabel != null) {
            String prefix = (selectedEvent != null) ? ("Event " + selectedEvent + " • ") : "";
            rateLabel.setText(prefix + String.format("Participation Rate: %.1f%%", rate));
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
