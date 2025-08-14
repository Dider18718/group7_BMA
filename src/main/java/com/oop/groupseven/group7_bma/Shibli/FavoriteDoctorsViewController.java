package com.oop.groupseven.group7_bma.Patient;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Favorite Doctors view.
 * Allows patients to mark and unmark favorite doctors for quick booking.
 */
public class FavoriteDoctorsViewController {

    @FXML
    private ListView<String> favoriteDoctorsList;

    @FXML
    public void initialize() {
        // Example favorite doctors
        favoriteDoctorsList.setItems(FXCollections.observableArrayList(
                "Dr. Rahman - Cardiology",
                "Dr. Ahmed - Neurology"
        ));
    }

    @FXML
    public void removeFavorite(ActionEvent event) {
        String selected = favoriteDoctorsList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            favoriteDoctorsList.getItems().remove(selected);
        }
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
