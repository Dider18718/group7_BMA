package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class PharmacyOperator6_ExpiryDateOfMedicinesViewController {
    @javafx.fxml.FXML
    private TableColumn <MedicineRecord, String>colExpiryDate;
    @javafx.fxml.FXML
    private TableColumn <MedicineRecord, String>colMedicine;
    @javafx.fxml.FXML
    private TableColumn <MedicineRecord, String>colStatus;
    @javafx.fxml.FXML
    private TableView <MedicineRecord>expiryTableView;

    private ObservableList<MedicineRecord> medicineList;

    @javafx.fxml.FXML
    public void initialize() {
        // Mock data (can later come from DB)
        medicineList = FXCollections.observableArrayList(
                new MedicineRecord("Paracetamol", "2025-01-15", "OK"),
                new MedicineRecord("Amoxicillin", "2024-09-01", "Critical"),
                new MedicineRecord("Ibuprofen", "2023-12-20", "Expired")
        );

        colMedicine.setCellValueFactory(cellData -> cellData.getValue().medicineNameProperty());
        colExpiryDate.setCellValueFactory(cellData -> cellData.getValue().expiryDateProperty());
        colStatus.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        expiryTableView.setItems(medicineList);
    }


    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent)throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/pharmacyOperatorDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Pharmacy Operator Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void markAsDisposalButtonOnAction(ActionEvent actionEvent) {
        MedicineRecord selected = expiryTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Disposed");
            expiryTableView.refresh();
            showAlert(Alert.AlertType.INFORMATION, "Updated", selected.getMedicineName() + " marked as Disposal.");
        } else {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a medicine first.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void tagAsCriticalButtonOnAction(ActionEvent actionEvent) {
        MedicineRecord selected = expiryTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Critical");
            expiryTableView.refresh();
            showAlert(Alert.AlertType.INFORMATION, "Updated", selected.getMedicineName() + " tagged as Critical.");
        } else {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a medicine first.");
        }
    }



    PharmacyOperatorDashboardController PharmacyOperatorDashboardController ;

    public void setter(TextArea pharmacyOperatorTextArea) { this.PharmacyOperatorDashboardController = PharmacyOperatorDashboardController ;
    }
}
