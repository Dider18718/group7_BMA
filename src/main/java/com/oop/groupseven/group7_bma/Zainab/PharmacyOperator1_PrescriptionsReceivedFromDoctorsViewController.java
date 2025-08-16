package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PharmacyOperator1_PrescriptionsReceivedFromDoctorsViewController
{
    @javafx.fxml.FXML
    private TableColumn <PrescriptionRecord, String>colTime;
    @javafx.fxml.FXML
    private TableColumn <PrescriptionRecord, String>colDoctor;
    @javafx.fxml.FXML
    private ComboBox filterByDoctorPatientComboBox;
    @javafx.fxml.FXML
    private TableColumn <PrescriptionRecord, String>colPatient;
    @javafx.fxml.FXML
    private TableColumn <PrescriptionRecord, String>colStatus;
    @javafx.fxml.FXML
    private TableView<PrescriptionRecord> prescriptionTableView;

    private ObservableList<PrescriptionRecord> prescriptionList = FXCollections.observableArrayList();

    private PharmacyOperatorDashboardController pharmacyOperatorDashboardController;

    @javafx.fxml.FXML
    public void initialize() {
        // Set up columns
        colTime.setCellValueFactory(data -> data.getValue().timeProperty());
        colDoctor.setCellValueFactory(data -> data.getValue().doctorProperty());
        colPatient.setCellValueFactory(data -> data.getValue().patientProperty());
        colStatus.setCellValueFactory(data -> data.getValue().statusProperty());

        // Sample data (in real case, would come from DB or Doctor’s submission)
        prescriptionList.addAll(
                new PrescriptionRecord("09:00 AM", "Dr. Zainab", "Patient A", "Pending"),
                new PrescriptionRecord("10:15 AM", "Dr. Khan", "Patient B", "Pending"),
                new PrescriptionRecord("11:30 AM", "Dr. Rahman", "Patient C", "Pending")
        );

        prescriptionTableView.setItems(prescriptionList);

        // Populate filter options
        filterByDoctorPatientComboBox.getItems().addAll("All", "Dr. Zainab", "Dr. Khan", "Dr. Rahman", "Patient A", "Patient B", "Patient C");
        filterByDoctorPatientComboBox.setValue("All");

        // Apply filter
        filterByDoctorPatientComboBox.setOnAction(event -> {
            String filter = filterByDoctorPatientComboBox.getValue().toString();
            if (filter.equals("All")) {
                prescriptionTableView.setItems(prescriptionList);
            } else {
                prescriptionTableView.setItems(prescriptionList.filtered(
                        rec -> rec.getDoctor().equals(filter) || rec.getPatient().equals(filter)
                ));
            }
        });
    }


    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/pharmacyOperatorDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Pharmacy Operator Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void MarkAsInProgressButtonOnAction(ActionEvent actionEvent) {
        PrescriptionRecord selected = prescriptionTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("In Progress");
            prescriptionTableView.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Status Updated");
            alert.setHeaderText("Prescription Processing Started");
            alert.setContentText("Prescription for " + selected.getPatient() + " is now In Progress.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a prescription to mark as In Progress.");
            alert.showAndWait();
        }
    }

    PharmacyOperatorDashboardController PharmacyOperatorDashboardController ;

    public void setter(TextArea pharmacyOperatorTextArea) { this.PharmacyOperatorDashboardController = PharmacyOperatorDashboardController ;
    }
}