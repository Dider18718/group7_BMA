package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class Doctor6_RecommendDiagnosticTestsFromController {
    @javafx.fxml.FXML
    private TextArea notesTextArea;
    @javafx.fxml.FXML
    private ComboBox <String>listOfTestsComboBox;
    @javafx.fxml.FXML
    private ComboBox <String>urgencyLevelComboBox;


    @javafx.fxml.FXML
    public void initialize() {
        // Populate test options
        listOfTestsComboBox.getItems().addAll("Blood Test", "X-Ray", "MRI Scan", "CT Scan", "Ultrasound", "ECG", "Urine Analysis");

        // Populate urgency levels
        urgencyLevelComboBox.getItems().addAll("Low", "Medium", "High", "Critical");
    }

    @javafx.fxml.FXML
    public void submitRecommendationButtonOnAction(ActionEvent actionEvent) {
        String test = listOfTestsComboBox.getValue();
        String urgency = urgencyLevelComboBox.getValue();
        String notes = notesTextArea.getText();

        if (test == null || urgency == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing Information");
            alert.setHeaderText(null);
            alert.setContentText("Please select a test and urgency level before submitting.");
            alert.showAndWait();
            return;
        }

        DiagnosticTestRecommendation recommendation =
                new DiagnosticTestRecommendation(test, urgency, notes);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Recommendation Submitted");
        alert.setHeaderText("Recommendation Saved Successfully");
        alert.setContentText(recommendation.toString());
        alert.showAndWait();

        // clear form
        listOfTestsComboBox.getSelectionModel().clearSelection();
        urgencyLevelComboBox.getSelectionModel().clearSelection();
        notesTextArea.clear();
    }


    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/doctorDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Doctor Dashboard");
        stage.show();
    }

    DoctorDashboardController DoctorDashboardController ;

    public void setter(TextArea doctorDashboardTextArea) { this.DoctorDashboardController = DoctorDashboardController ; }
}
