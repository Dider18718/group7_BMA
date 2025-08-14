package com.oop.groupseven.group7_bma.Patient;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Book Appointment view.
 * Allows patients to choose doctor, date, and time slot.
 */
public class BookAppointmentViewController {

    @FXML
    private ComboBox<String> doctorCombo;

    @FXML
    private DatePicker appointmentDatePicker;

    @FXML
    private ComboBox<String> timeSlotCombo;

    @FXML
    public void initialize() {
        doctorCombo.setItems(FXCollections.observableArrayList(
                "Dr. Rahman - Cardiology",
                "Dr. Ahmed - Neurology",
                "Dr. Khan - Orthopedics"
        ));

        timeSlotCombo.setItems(FXCollections.observableArrayList(
                "09:00 AM", "10:00 AM", "11:00 AM",
                "02:00 PM", "03:00 PM", "04:00 PM"
        ));
    }

    @FXML
    public void confirmBooking(ActionEvent event) {
        // TODO: Save booking details to database
        System.out.println("Appointment booked with: " + doctorCombo.getValue());
        System.out.println("Date: " + appointmentDatePicker.getValue());
        System.out.println("Time: " + timeSlotCombo.getValue());
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
