package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Doctor5_UpdatePatientTreatmentDetailsController {
    @javafx.fxml.FXML
    private TextArea therapyDietInstructionsTextArea;
    @javafx.fxml.FXML
    private TextField dosageTextField;
    @javafx.fxml.FXML
    private TextField medicineNameTextField;

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/doctorDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Doctor Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void submitChangesButtonOnAction(ActionEvent actionEvent) {
        String medicine = medicineNameTextField.getText();
        String dosage = dosageTextField.getText();
        String therapy = therapyDietInstructionsTextArea.getText();

        if (medicine.isBlank() || dosage.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing Information");
            alert.setHeaderText(null);
            alert.setContentText("Medicine name and dosage are required.");
            alert.showAndWait();
            return;
        }

        TreatmentDetails treatment = new TreatmentDetails(medicine, dosage, therapy);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Treatment Updated");
        alert.setHeaderText("Treatment details recorded successfully");
        alert.setContentText(treatment.toString());
        alert.showAndWait();

        // Clear inputs after submission
        medicineNameTextField.clear();
        dosageTextField.clear();
        therapyDietInstructionsTextArea.clear();
    }

    DoctorDashboardController DoctorDashboardController ;

    public void setter(TextArea doctorDashboardTextArea) { this.DoctorDashboardController = DoctorDashboardController ; }
}
