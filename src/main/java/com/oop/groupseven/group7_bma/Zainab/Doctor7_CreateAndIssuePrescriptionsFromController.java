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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class Doctor7_CreateAndIssuePrescriptionsFromController {
    @javafx.fxml.FXML
    private TableColumn<PrescriptionItem, String> colName;
    @javafx.fxml.FXML
    private TableColumn<PrescriptionItem, String> colDosage;
    @javafx.fxml.FXML
    private TableColumn<PrescriptionItem, String> colDuration;
    @javafx.fxml.FXML
    private TextArea usageInstructionTextArea;
    @javafx.fxml.FXML
    private TextField medicineSearchTextField;
    @javafx.fxml.FXML
    private TableView<PrescriptionItem> prescriptionTableView;
    @javafx.fxml.FXML
    private TextField durationTextField;
    @javafx.fxml.FXML
    private TextField dosageTextField;

    private final ObservableList<PrescriptionItem> prescriptionList = FXCollections.observableArrayList();

    private DoctorDashboardController doctorDashboardController;

    @javafx.fxml.FXML
    public void initialize() {
        // Bind table columns to PrescriptionItem getters
        colName.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        colDosage.setCellValueFactory(new PropertyValueFactory<>("dosage"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));

        // Set items in TableView
        prescriptionTableView.setItems(prescriptionList);
    }

    public PrescriptionItem getPrescriptionItem() {
        return prescriptionTableView.getSelectionModel().getSelectedItem();
    }

    @javafx.fxml.FXML
    public void sendToPharmacyButtonOnAction(ActionEvent actionEvent) {
        String medicine = medicineSearchTextField.getText();
        String dosage = dosageTextField.getText();
        String duration = durationTextField.getText();
        String usageInstruction = usageInstructionTextArea.getText();

        // Validation
        if (medicine.isBlank() || dosage.isBlank() || duration.isBlank() || usageInstruction.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing Information");
            alert.setHeaderText(null);
            alert.setContentText("Please enter medicine name, dosage, duration, and usage instruction.");
            alert.showAndWait();
            return;
        }

        PrescriptionItem item = new PrescriptionItem(medicine, dosage, duration, usageInstruction);
        prescriptionList.add(item);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Prescription Sent");
        alert.setHeaderText("Prescription issued to Pharmacy successfully");
        alert.setContentText(item.toString());
        alert.showAndWait();

        medicineSearchTextField.clear();
        dosageTextField.clear();
        durationTextField.clear();
        usageInstructionTextArea.clear();
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/doctorDashboard.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Doctor Dashboard");
        stage.show();
    }

    private DoctorDashboardController DoctorDashboardController;

    public void setter(TextArea doctorDashboardTextArea) {
        this.DoctorDashboardController = DoctorDashboardController;
    }
}
