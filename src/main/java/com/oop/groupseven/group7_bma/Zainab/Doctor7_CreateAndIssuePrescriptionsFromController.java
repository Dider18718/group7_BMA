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

public class Doctor7_CreateAndIssuePrescriptionsFromController {
    @javafx.fxml.FXML
    private TableColumn <PrescriptionItem, String>colName;
    @javafx.fxml.FXML
    private TableColumn <PrescriptionItem, String>colDosage;
    @javafx.fxml.FXML
    private TableColumn <PrescriptionItem, String>colDuration;
    @javafx.fxml.FXML
    private TextArea usageInstructionTextArea;
    @javafx.fxml.FXML
    private TextField medicineSearchTextField;
    @javafx.fxml.FXML
    private TableView<PrescriptionItem> prescriptionTableView;

    private ObservableList<PrescriptionItem> prescriptionList = FXCollections.observableArrayList();

    private DoctorDashboardController doctorDashboardController;

    @javafx.fxml.FXML
    public void initialize() {
        // Bind table columns
        colName.setCellValueFactory(data -> data.getValue().nameProperty());
        colDosage.setCellValueFactory(data -> data.getValue().dosageProperty());
        colDuration.setCellValueFactory(data -> data.getValue().durationProperty());

        prescriptionTableView.setItems(prescriptionList);
    }

    @javafx.fxml.FXML
    public void sendToPharmacyButtonOnAction(ActionEvent actionEvent) {
        String medicine = medicineSearchTextField.getText();
        String usageInstruction = usageInstructionTextArea.getText();

        if (medicine.isBlank() || usageInstruction.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing Information");
            alert.setHeaderText(null);
            alert.setContentText("Please enter medicine name and usage instruction.");
            alert.showAndWait();
            return;
        }

        // For now, we will assume default dosage/duration input for demo
        PrescriptionItem item = new PrescriptionItem(medicine, "1 tablet", "7 days", usageInstruction);
        prescriptionList.add(item);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Prescription Sent");
        alert.setHeaderText("Prescription issued to Pharmacy successfully");
        alert.setContentText(item.toString());
        alert.showAndWait();

        // Clear input fields
        medicineSearchTextField.clear();
        usageInstructionTextArea.clear();
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
}
