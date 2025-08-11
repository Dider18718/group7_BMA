package com.oop.groupseven.group7_bma.MedicalInspector;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Cleaning Status view.
 * Allows Medical Inspector to update cleaning status of rooms.
 */
public class CleaningStatusViewController {

    @FXML
    private TableView<?> cleaningTable;

    @FXML
    private TableColumn<?, ?> roomIdCol;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private TableColumn<?, ?> lastCleanedCol;

    @FXML
    private ComboBox<String> statusCombo;

    @FXML
    public void initialize() {
        // Fill combo box options
        statusCombo.setItems(FXCollections.observableArrayList("Clean", "Needs Recleaning"));
    }

    @FXML
    public void handleUpdateStatus(ActionEvent event) {
        // TODO: Update selected row in database
        System.out.println("Updated status to: " + statusCombo.getValue());
    }

    @FXML
    public void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/oop/groupseven/group7_bma/MedicalInspector/MedicalInspectorDashboardView.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Inspector Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
