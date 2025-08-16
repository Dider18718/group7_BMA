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

public class PharmacyOperator7_SearchForMedicineController {
    @javafx.fxml.FXML
    private TableColumn <MedicineResult, String>colSearchResults;
    @javafx.fxml.FXML
    private ComboBox <String>filterComboBox;
    @javafx.fxml.FXML
    private TextField keywordTextField;
    @javafx.fxml.FXML
    private TableView<MedicineResult> searchResultsTableView;

    private ObservableList<MedicineResult> medicineDatabase;

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize filter options
        filterComboBox.setItems(FXCollections.observableArrayList("Name", "Type", "Use"));

        // Mock medicine database (replace with DB later)
        medicineDatabase = FXCollections.observableArrayList(
                new MedicineResult("Paracetamol - Pain Reliever"),
                new MedicineResult("Amoxicillin - Antibiotic"),
                new MedicineResult("Ibuprofen - Anti-inflammatory"),
                new MedicineResult("Cetirizine - Allergy Relief"),
                new MedicineResult("Metformin - Diabetes Control")
        );

        // Bind column to property
        colSearchResults.setCellValueFactory(cellData -> cellData.getValue().resultTextProperty());
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
    public void searchButtonOnAction(ActionEvent actionEvent) {
        String keyword = keywordTextField.getText().trim().toLowerCase();
        String filter = filterComboBox.getValue();

        if (keyword.isEmpty() || filter == null) {
            showAlert(Alert.AlertType.WARNING, "Input Required", "Please enter a keyword and select a filter.");
            return;
        }

        // For now, search is simple keyword contains check
        ObservableList<MedicineResult> filteredResults = FXCollections.observableArrayList();
        for (MedicineResult medicine : medicineDatabase) {
            if (medicine.getResultText().toLowerCase().contains(keyword)) {
                filteredResults.add(medicine);
            }
        }

        if (filteredResults.isEmpty()) {
            showAlert(Alert.AlertType.INFORMATION, "No Results", "No medicine found for: " + keyword);
        }

        searchResultsTableView.setItems(filteredResults);
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
