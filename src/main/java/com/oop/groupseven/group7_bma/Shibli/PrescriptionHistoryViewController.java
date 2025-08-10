package com.oop.groupseven.group7_bma.Patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Prescription History view.
 * Shows patient's past prescriptions.
 */
public class PrescriptionHistoryViewController {

    @FXML
    private TableView<?> prescriptionTable;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private TableColumn<?, ?> doctorCol;

    @FXML
    private TableColumn<?, ?> prescriptionCol;

    @FXML
    public void downloadSelectedPrescription(ActionEvent event) {
        // TODO: Implement file download logic
        System.out.println("Downloading selected prescription...");
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
