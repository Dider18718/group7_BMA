package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class Doctor8_PrescriptionHistoryForAPatientViewController {
    @javafx.fxml.FXML
    private TextArea notesTextArea;
    @javafx.fxml.FXML
    private TableColumn <PrescriptionHistoryItem, String>colDosage;
    @javafx.fxml.FXML
    private DatePicker filterByDatePicker;
    @javafx.fxml.FXML
    private TableColumn <PrescriptionHistoryItem, String>colMedicine;
    @javafx.fxml.FXML
    private TableColumn <PrescriptionHistoryItem, String>colDate;
    @javafx.fxml.FXML
    private TableView<PrescriptionHistoryItem> prescriptionHistoryTableView;

    private ObservableList<PrescriptionHistoryItem> prescriptionHistory = FXCollections.observableArrayList();

    private DoctorDashboardController doctorDashboardController;

    @javafx.fxml.FXML
    public void initialize() {
        // Bind table columns
        colDate.setCellValueFactory(data -> data.getValue().dateProperty());
        colMedicine.setCellValueFactory(data -> data.getValue().medicineProperty());
        colDosage.setCellValueFactory(data -> data.getValue().dosageProperty());

        // Load sample data
        prescriptionHistory.addAll(
                new PrescriptionHistoryItem("2025-08-01", "Paracetamol", "500mg"),
                new PrescriptionHistoryItem("2025-08-05", "Amoxicillin", "250mg"),
                new PrescriptionHistoryItem("2025-08-10", "Ibuprofen", "200mg")
        );

        prescriptionHistoryTableView.setItems(prescriptionHistory);

        // Filter by date
        filterByDatePicker.setOnAction(event -> {
            LocalDate selectedDate = filterByDatePicker.getValue();
            if (selectedDate != null) {
                prescriptionHistoryTableView.setItems(prescriptionHistory.filtered(
                        item -> item.getDate().equals(selectedDate.toString())
                ));
            } else {
                prescriptionHistoryTableView.setItems(prescriptionHistory);
            }
        });
    }


    @javafx.fxml.FXML
    public void sendInquiryToPharmacyButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Inquiry Sent");
        alert.setHeaderText("Pharmacy Inquiry");
        alert.setContentText("Inquiry regarding prescription history has been sent to the pharmacy.");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void exportPrintButtonOnAction(ActionEvent actionEvent) {
        Printer printer = Printer.getDefaultPrinter();
        if (printer == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No Printer Found");
            alert.setHeaderText(null);
            alert.setContentText("No printer is available on this system.");
            alert.showAndWait();
            return;
        }

        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null && job.showPrintDialog(prescriptionHistoryTableView.getScene().getWindow())) {
            boolean success = job.printPage(prescriptionHistoryTableView);
            if (success) {
                job.endJob();
            }
        }
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

    DoctorDashboardController DoctorDashboardController ;

    public void setter(TextArea doctorDashboardTextArea) { this.DoctorDashboardController = DoctorDashboardController ; }
}
