package com.oop.groupseven.group7_bma.Patient;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Feedback Submission view.
 * Allows patients to submit ratings and feedback after service.
 */
public class FeedbackSubmissionViewController {

    @FXML
    private ComboBox<Integer> ratingCombo;

    @FXML
    private TextArea feedbackArea;

    @FXML
    public void initialize() {
        ratingCombo.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
    }

    @FXML
    public void submitFeedback(ActionEvent event) {
        // TODO: Save feedback to database
        System.out.println("Rating: " + ratingCombo.getValue());
        System.out.println("Feedback: " + feedbackArea.getText());
    }

    @FXML
    public void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(
                    "/com/oop/groupseven/group7_bma/Patient/PatientDashboardView.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Patient Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
