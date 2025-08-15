package com.oop.groupseven.group7_bma.Sujarna;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;
import java.io.IOException;
import java.net.URL;

public class MedicalTransportDriverGoal1Controller {

    // Table & columns
    @javafx.fxml.FXML private TableView<ScheduleRow> scheduleTable;
    @javafx.fxml.FXML private TableColumn<ScheduleRow, String> patientColumn;
    @javafx.fxml.FXML private TableColumn<ScheduleRow, String> timeColumn;
    @javafx.fxml.FXML private TableColumn<ScheduleRow, String> pickupColumn;
    @javafx.fxml.FXML private TableColumn<ScheduleRow, String> dropColumn;

    // Labels (names end with 'Vbox' in FXML but are Labels)
    @javafx.fxml.FXML private Label patientVbox;
    @javafx.fxml.FXML private Label pickupVbox;
    @javafx.fxml.FXML private Label dropVbox;

    private final ObservableList<ScheduleRow> data = FXCollections.observableArrayList();

    // Row model for TableView
    public static class ScheduleRow {
        private final SimpleStringProperty patient = new SimpleStringProperty();
        private final SimpleStringProperty time = new SimpleStringProperty();
        private final SimpleStringProperty pickup = new SimpleStringProperty();
        private final SimpleStringProperty drop = new SimpleStringProperty();

        public ScheduleRow(String patient, String time, String pickup, String drop) {
            this.patient.set(patient);
            this.time.set(time);
            this.pickup.set(pickup);
            this.drop.set(drop);
        }
        public String getPatient() { return patient.get(); }
        public String getTime() { return time.get(); }
        public String getPickup() { return pickup.get(); }
        public String getDrop() { return drop.get(); }
    }

    @javafx.fxml.FXML
    public void initialize() {
        if (scheduleTable != null) {
            scheduleTable.setItems(data);
        }
        if (patientColumn != null) {
            patientColumn.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getPatient()));
        }
        if (timeColumn != null) {
            timeColumn.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getTime()));
        }
        if (pickupColumn != null) {
            pickupColumn.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getPickup()));
        }
        if (dropColumn != null) {
            dropColumn.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getDrop()));
        }
    }

    @javafx.fxml.FXML
    public void scheduleButton(ActionEvent actionEvent) {
        // Use labels to form a demo schedule entry so fields are 'accessed'
        String patient = patientVbox != null ? patientVbox.getText() : "Unknown";
        String pickup  = pickupVbox  != null ? pickupVbox.getText()  : "Pickup";
        String drop    = dropVbox    != null ? dropVbox.getText()    : "Drop";

        // Create a simple time marker based on current table size
        String time = String.format("%02d:%02d", (data.size() % 24), (data.size() * 5) % 60);

        if (scheduleTable != null) {
            data.add(new ScheduleRow(patient, time, pickup, drop));
        }
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void viewMapButton(ActionEvent actionEvent) {
        // Minimal feedback to show action was handled
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Map");
        alert.setContentText("Opening map for route: " + (pickupVbox != null ? pickupVbox.getText() : "?")
                + " → " + (dropVbox != null ? dropVbox.getText() : "?"));
        alert.showAndWait();
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static final String BASE = "/com/oop/groupseven/group7_bma/Sujarna/";

    private void navigateToDashboard(ActionEvent event) {
        // Inline navigation (no helper with constant parameter -> avoids inspection warning)
        URL url = this.getClass().getResource(BASE + "MedicalTransportDriverDashboard.fxml");
        if (url == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Missing FXML");
            a.setContentText("Could not find resource: " + BASE + "MedicalTransportDriverDashboard.fxml" + System.lineSeparator()
                    + "Make sure it is on the classpath under src/main/resources");
            a.showAndWait();
            return;
        }
        try {
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Navigation Error");
            a.setContentText(e.getMessage());
            a.showAndWait();
        }
    }
}
