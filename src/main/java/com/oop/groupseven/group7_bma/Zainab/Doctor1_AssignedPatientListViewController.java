package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.beans.property.SimpleStringProperty;
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
import java.time.LocalDate;
import java.time.LocalTime;

public class Doctor1_AssignedPatientListViewController
{
    @javafx.fxml.FXML
    private TableColumn <Patient, String> colPatientName;
    @javafx.fxml.FXML
    private TextField quickSearchTextField;
    @javafx.fxml.FXML
    private TableColumn <Patient, String> colDepartmentOrReason;
    @javafx.fxml.FXML
    private TableColumn <Patient, String> colAppointmentTime;
    @javafx.fxml.FXML
    private TableView <Patient>patientTableView;
    @javafx.fxml.FXML
    private TableColumn<Patient, String> colPatientID;

    private DoctorDashboardController doctorDashboardController;
    private ObservableList<Patient> patientList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private DatePicker selectDatePicker;

    // Setter from DoctorDashboardController
    public void setter(DoctorDashboardController controller) {
        this.doctorDashboardController = controller;
    }


    @javafx.fxml.FXML
    public void initialize() {
        // Bind table columns to Patient model
        colPatientID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colPatientName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        colAppointmentTime.setCellValueFactory(cellData -> new SimpleStringProperty(LocalTime.now().toString()));
        colDepartmentOrReason.setCellValueFactory(cellData -> new SimpleStringProperty("General Checkup"));
    }

    @javafx.fxml.FXML
    public void fetchListButtonOnAction(ActionEvent actionEvent) {
        // Simulated fetch – later you can filter by doctor ID and date
        patientList.clear();
        patientList.add(new Patient("John Doe", "0123456789", "john@mail.com", "Dhaka", "Male", "1234",
                LocalDate.of(1995, 5, 20), "01711112222"));
        patientList.add(new Patient("Jane Smith", "0987654321", "jane@mail.com", "Chittagong", "Female", "5678",
                LocalDate.of(1992, 3, 15), "01999998888"));
        patientTableView.setItems(patientList);
    }


    @javafx.fxml.FXML
    public void startConsultationButtonOnAction(ActionEvent actionEvent) {
        Patient selected = patientTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Consultation Start");
            alert.setHeaderText("Starting Consultation");
            alert.setContentText("Consultation with: " + selected.getName());
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setContentText("Please select a patient first.");
            alert.showAndWait();
        }
    }

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

    DoctorDashboardController DoctorDashboardController ;

    public void setter(TextArea doctorDashboardTextArea) { this.DoctorDashboardController = DoctorDashboardController ; }

    @javafx.fxml.FXML
    public void selectDatePickerOnAction(ActionEvent actionEvent) {
        LocalDate selectedDate = selectDatePicker.getValue();
        if (selectedDate != null) {
            // For now just show confirmation – later filter appointments by this date
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Date Selected");
            alert.setContentText("Fetching appointments for: " + selectedDate);
            alert.showAndWait();
        }
    }
}