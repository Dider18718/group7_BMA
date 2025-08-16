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

public class Doctor2_PersonalScheduleandAppointmentsViewController {
    @javafx.fxml.FXML
    private TextArea notesTextArea;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> colTime;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> colPatientName;
    @javafx.fxml.FXML
    private TableColumn <Appointment, String>colPurpose;
    @javafx.fxml.FXML
    private TableColumn <Appointment, String>colStatus;
    @javafx.fxml.FXML
    private TableView <Appointment>appointmentTableView;
    @javafx.fxml.FXML
    private DatePicker selectDatePicker;



    private ObservableList<Appointment> appointmentsList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        // Setup table columns
        colTime.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTime()));
        colPatientName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPatientName()));
        colPurpose.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPurpose()));
        colStatus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus()));

        // Load some demo data
        loadAppointments(LocalDate.now());
    }

    private void loadAppointments(LocalDate date) {
        appointmentsList.clear();
        // Example demo appointments
        appointmentsList.add(new Appointment("09:00 AM", "John Doe", "Follow-up", "Pending"));
        appointmentsList.add(new Appointment("10:30 AM", "Jane Smith", "General Checkup", "Pending"));
        appointmentTableView.setItems(appointmentsList);
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

    @javafx.fxml.FXML
    public void markAsCompletedButtonOnAction(ActionEvent actionEvent) {
        Appointment selected = appointmentTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Completed");
            appointmentTableView.refresh();
            notesTextArea.appendText("\nMarked as Completed.");
        } else {
            showWarning("Please select an appointment to mark as completed.");
        }
    }

    private void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void viewDetailsButtonOnAction(ActionEvent actionEvent) {
        Appointment selected = appointmentTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            notesTextArea.setText(
                    "Patient: " + selected.getPatientName() + "\n" +
                    "Purpose: " + selected.getPurpose() + "\n" +
                    "Time: " + selected.getTime() + "\n" +
                    "Status: " + selected.getStatus()
            );
        } else {
            showWarning("Please select an appointment to view details.");
        }
    }

    DoctorDashboardController DoctorDashboardController ;

    public void setter(TextArea doctorDashboardTextArea) { this.DoctorDashboardController = DoctorDashboardController ; }

    @javafx.fxml.FXML
    public void selectDatePickerOnAction(ActionEvent actionEvent) {
        LocalDate selectedDate = selectDatePicker.getValue();
        if (selectedDate != null) {
            loadAppointments(selectedDate);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments Loaded");
            alert.setContentText("Showing appointments for " + selectedDate);
            alert.showAndWait();
        }
    }
}
