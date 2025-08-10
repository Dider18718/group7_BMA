package com.oop.groupseven.group7_bma.MedicalInspector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Ambulance Fuel Check view.
 * Used to log and update fuel status for ambulances.
 */
public class AmbulanceFuelCheckViewController {

    @FXML
    private TableView<?> ambulanceTable;

    @FXML
    private TableColumn<?, ?> ambulanceIdCol;

    @FXML
    private TableColumn<?, ?> fuelLevelCol;

    @FXML
    private TextField fuelInputField;

    @FXML
    public void updateFuelLevel(ActionEvent event) {
        // TODO: Update the selected ambulance's fuel level in the database
        System.out.println("Fuel updated to: " + fuelInputField.getText() + " liters");
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
