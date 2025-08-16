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
import java.util.stream.Collectors;

public class Doctor3_AccessPatientMedicalHistoryController {
    @javafx.fxml.FXML
    private DatePicker filterByDatePicker;
    @javafx.fxml.FXML
    private TextArea internalNotesTextArea;
    @javafx.fxml.FXML
    private TableColumn <MedicalRecord, String> colType;
    @javafx.fxml.FXML
    private TableColumn <MedicalRecord, String> colSummary;
    @javafx.fxml.FXML
    private ComboBox <String> filterByRecordCombobox;
    @javafx.fxml.FXML
    private TableColumn <MedicalRecord, String> colDate;
    @javafx.fxml.FXML
    private TableView<MedicalRecord> historyTableView;


    private ObservableList<MedicalRecord> allRecords = FXCollections.observableArrayList();
    private ObservableList<MedicalRecord> filteredRecords = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        // Setup table columns
        // Setup table columns
        colDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
        colType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
        colSummary.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSummary()));

        // Setup filter options
        filterByRecordCombobox.getItems().addAll("Diagnosis", "Prescription", "Test Result");

        // Load demo records
        allRecords.add(new MedicalRecord(LocalDate.of(2023, 3, 10), "Diagnosis", "Flu, prescribed rest"));
        allRecords.add(new MedicalRecord(LocalDate.of(2023, 6, 5), "Prescription", "Amoxicillin, 500mg"));
        allRecords.add(new MedicalRecord(LocalDate.of(2023, 9, 1), "Test Result", "Blood test - Normal"));

        filteredRecords.setAll(allRecords);
        historyTableView.setItems(filteredRecords);

        System.out.println("Records loaded: " + allRecords.size());
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
    public void viewRecordButtonOnAction(ActionEvent actionEvent) {
        MedicalRecord selected = historyTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Medical Record Details");
            alert.setHeaderText("Record: " + selected.getType());
            alert.setContentText(
                    "Date: " + selected.getDate() + "\n" +
                            "Summary: " + selected.getSummary() + "\n\n" +
                            "Notes: " + internalNotesTextArea.getText()
            );
            alert.showAndWait();

            // TODO: optionally save internalNotesTextArea text to database/file
        } else {
            showWarning("Please select a record to view.");
        }
    }

    private void showWarning(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText(msg);
        alert.showAndWait();
    }


    public void filterByDatePickerOnAction(ActionEvent actionEvent) {
        LocalDate selectedDate = filterByDatePicker.getValue();
        if (selectedDate != null) {
            filteredRecords.setAll(allRecords.stream()
                    .filter(record -> record.getDate().equals(selectedDate))
                    .collect(Collectors.toList()));
        } else {
            filteredRecords.setAll(allRecords);
        }
    }

    public void filterByRecordComboboxOnAction(ActionEvent actionEvent) {
        String type = filterByRecordCombobox.getValue();
        if (type != null) {
            filteredRecords.setAll(allRecords.stream()
                    .filter(record -> record.getType().equals(type))
                    .collect(Collectors.toList()));
        } else {
            filteredRecords.setAll(allRecords);
        }
    }

    DoctorDashboardController DoctorDashboardController ;

    public void setter(TextArea doctorDashboardTextArea) { this.DoctorDashboardController = DoctorDashboardController ; }
}
