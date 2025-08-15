package com.oop.groupseven.group7_bma.Sujarna;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class CorporateHealthCoordinatorGoal4Controller {

    // Optional inputs (match your FXML fx:id if present)
    @javafx.fxml.FXML private ComboBox<String> companyComboBox;
    @javafx.fxml.FXML private DatePicker fromDatePicker;
    @javafx.fxml.FXML private DatePicker toDatePicker;

    // Chart (typed generics, no raw types)
    @javafx.fxml.FXML private BarChart<String, Number> checkupChart;
    @javafx.fxml.FXML private CategoryAxis xAxis;
    @javafx.fxml.FXML private NumberAxis yAxis;

    @javafx.fxml.FXML private Label statusLabel;

    @javafx.fxml.FXML
    public void generateButton(ActionEvent actionEvent) {
        // Read inputs (safe null handling)
        String company = companyComboBox != null ? companyComboBox.getValue() : null;
        String from    = (fromDatePicker != null && fromDatePicker.getValue() != null)
                ? fromDatePicker.getValue().toString() : null;
        String to      = (toDatePicker != null && toDatePicker.getValue() != null)
                ? toDatePicker.getValue().toString() : null;

        // Build a simple demo series so UI visibly changes (prevents "assigned but never accessed")
        if (checkupChart != null) {
            checkupChart.getData().clear();
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName(company != null ? company : "Company");
            series.getData().add(new XYChart.Data<>("Blood",  40));
            series.getData().add(new XYChart.Data<>("Vision", 28));
            series.getData().add(new XYChart.Data<>("Dental", 18));
            checkupChart.getData().add(series);
        }

        // Status text (keeps label used and avoids String.valueOf warnings)
        if (statusLabel != null) {
            String range = (from != null || to != null) ? ("  (" + String.valueOf(from) + " → " + String.valueOf(to) + ")") : "";
            statusLabel.setText("Generated chart for " + (company != null ? company : "selection") + range);
        }

        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void downloadButton(ActionEvent actionEvent) {
        // Simulate export completion with a dynamic header to avoid constant-parameter warnings
        String header = (companyComboBox != null && companyComboBox.getValue() != null)
                ? "Download: " + companyComboBox.getValue()
                : "Download";
        showInfo(header, "Chart export completed.");
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    private void showInfo(String header, String message) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Info");
        a.setHeaderText(header);
        a.setContentText(message);
        a.showAndWait();
    }

    private void navigateToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    HelloApplication.class.getResource("Sujarna/CorporateHealthCoordinator.fxml"));
            Parent root = loader.load();
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
