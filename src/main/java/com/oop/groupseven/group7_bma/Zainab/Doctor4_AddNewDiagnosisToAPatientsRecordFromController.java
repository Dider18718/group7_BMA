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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Doctor4_AddNewDiagnosisToAPatientsRecordFromController
{
    @javafx.fxml.FXML
    private ComboBox <String>conditionSeverityComboBox;
    @javafx.fxml.FXML
    private TextArea notesTextField;
    @javafx.fxml.FXML
    private TextField diagonsisNameTextField;
    @javafx.fxml.FXML
    private TextField symptomsTextField;


    DoctorDashboardController DoctorDashboardController ;


    @javafx.fxml.FXML
    public void initialize() {
        // Fill severity levels
        conditionSeverityComboBox.getItems().addAll("Mild", "Moderate", "Severe", "Critical");
    }

    @javafx.fxml.FXML
    public void attachTestResultsOrImagesButtonOnAction(ActionEvent actionEvent) {
        // Later: implement file chooser for lab reports/images
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Attach Test Results");
        alert.setHeaderText(null);
        alert.setContentText("Feature coming soon: Attach lab reports or images.");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void submitButtonOnAction(ActionEvent actionEvent) {
        String symptoms = symptomsTextField.getText();
        String diagnosisName = diagonsisNameTextField.getText();
        String severity = conditionSeverityComboBox.getValue();
        String notes = notesTextField.getText();

        if (symptoms.isBlank() || diagnosisName.isBlank() || severity == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing Information");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all mandatory fields (symptoms, diagnosis name, severity).");
            alert.showAndWait();
            return;
        }

        Diagnosis diagnosis = new Diagnosis(symptoms, diagnosisName, severity, notes);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Diagnosis Added");
        alert.setHeaderText("Diagnosis Recorded Successfully");
        alert.setContentText(diagnosis.toString());
        alert.showAndWait();

        // clear fields
        symptomsTextField.clear();
        diagonsisNameTextField.clear();
        conditionSeverityComboBox.getSelectionModel().clearSelection();
        notesTextField.clear();
    }


    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/doctorDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Doctor Dashboard");
        stage.show();

    }
    public void setter(TextArea doctorDashboardTextArea) { this.DoctorDashboardController = DoctorDashboardController ; }
}