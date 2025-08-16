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

public class PharmacyOperator8_ManageMedicineInventoryLevelsFromController {
    @javafx.fxml.FXML
    private TableColumn <MedicineInventory, Integer> colQuantity;
    @javafx.fxml.FXML
    private TableColumn<MedicineInventory, String> colMedicineName;
    @javafx.fxml.FXML
    private TableColumn<MedicineInventory, Integer>  colThreshold;
    @javafx.fxml.FXML
    private TableView<MedicineInventory> inventoryTableView;

    private ObservableList<MedicineInventory> inventoryList;

    @javafx.fxml.FXML
    public void initialize() {
        // Mock Data (replace with DB later)
        inventoryList = FXCollections.observableArrayList(
                new MedicineInventory("Paracetamol", 120, 50),
                new MedicineInventory("Amoxicillin", 40, 30),
                new MedicineInventory("Ibuprofen", 10, 20),
                new MedicineInventory("Cetirizine", 70, 25)
        );

        // Bind columns
        colMedicineName.setCellValueFactory(cellData -> cellData.getValue().medicineNameProperty());
        colQuantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
        colThreshold.setCellValueFactory(cellData -> cellData.getValue().thresholdProperty().asObject());

        inventoryTableView.setItems(inventoryList);
    }

    @javafx.fxml.FXML
    public void recordReceivedItemsButtonOnAction(ActionEvent actionEvent) {
        MedicineInventory selected = inventoryTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a medicine to record items.");
            return;
        }

        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setTitle("Record Received Items");
        dialog.setHeaderText("Add stock for " + selected.getMedicineName());
        dialog.setContentText("Enter received quantity:");

        dialog.showAndWait().ifPresent(input -> {
            try {
                int received = Integer.parseInt(input);
                selected.setQuantity(selected.getQuantity() + received);
                inventoryTableView.refresh();
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Quantity must be a number.");
            }
        });
    }


    @javafx.fxml.FXML
    public void approveRestockButtonOnAction(ActionEvent actionEvent) {
        MedicineInventory selected = inventoryTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a medicine to approve restock.");
            return;
        }

        if (selected.getQuantity() >= selected.getThreshold()) {
            showAlert(Alert.AlertType.INFORMATION, "Restock Not Needed", selected.getMedicineName() + " already has sufficient stock.");
        } else {
            showAlert(Alert.AlertType.INFORMATION, "Restock Approved", "Restock approved for " + selected.getMedicineName());
        }
    }


    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
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
    public void setRecordThersholdButtonOnAction(ActionEvent actionEvent) {
        MedicineInventory selected = inventoryTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a medicine to set threshold.");
            return;
        }

        TextInputDialog dialog = new TextInputDialog(String.valueOf(selected.getThreshold()));
        dialog.setTitle("Set Threshold");
        dialog.setHeaderText("Set threshold for " + selected.getMedicineName());
        dialog.setContentText("Enter new threshold:");

        dialog.showAndWait().ifPresent(input -> {
            try {
                int newThreshold = Integer.parseInt(input);
                selected.setThreshold(newThreshold);
                inventoryTableView.refresh();
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Threshold must be a number.");
            }
        });
    }
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }






    PharmacyOperatorDashboardController PharmacyOperatorDashboardController ;

    public void setter(TextArea pharmacyOperatorTextArea) { this.PharmacyOperatorDashboardController = PharmacyOperatorDashboardController ;
    }
}
