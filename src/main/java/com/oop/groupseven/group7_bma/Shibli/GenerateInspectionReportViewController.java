package com.oop.groupseven.group7_bma.MedicalInspector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Generate Inspection Report view.
 * Allows Medical Inspector to generate and save a detailed inspection report.
 */
public class GenerateInspectionReportViewController {

    @FXML
    private DatePicker reportDatePicker;

    @FXML
    private TextArea reportContentArea;

    @FXML
    public void generateReport(ActionEvent event) {
        // TODO: Save report to file or database
        System.out.println("Generating report for date: " + reportDatePicker.getValue());
        System.out.println("Report content:\n" + reportContentArea.getText());
    }

    @FXML
    public void clearReport(ActionEvent event) {
        reportDatePicker.setValue(null);
        reportContentArea.clear();
    }

    @FXML
    public void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(
                    "/com/oop/groupseven/group7_bma/MedicalInspector/MedicalInspectorDashboardView.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Inspector Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
