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
import java.time.LocalDateTime;

@SuppressWarnings({ "SpellCheckingInspection", "FieldMayBeFinal" })
public class CorporateHealthCoordinatorGoal4Controller {

    // FXML-injected controls (must NOT be final)
    @javafx.fxml.FXML private ComboBox<String> companyComboBox = new ComboBox<>();
    @javafx.fxml.FXML private DatePicker fromDatePicker = new DatePicker();
    @javafx.fxml.FXML private DatePicker toDatePicker   = new DatePicker();

    @javafx.fxml.FXML private CategoryAxis xAxis = new CategoryAxis();
    @javafx.fxml.FXML private NumberAxis   yAxis = new NumberAxis();
    @javafx.fxml.FXML private BarChart<String, Number> checkupChart = new BarChart<>(xAxis, yAxis);

    @javafx.fxml.FXML private Label statusLabel = new Label();

    // Compatibility stubs because your FXML uses onAction="#<fx:id>"
    @SuppressWarnings("unused")
    @javafx.fxml.FXML
    public void companyComboBox(ActionEvent e) { if (statusLabel != null) statusLabel.setText("Company changed"); e.consume(); }

    @SuppressWarnings("unused")
    @javafx.fxml.FXML
    public void fromDatePicker(ActionEvent e) { e.consume(); }

    @SuppressWarnings("unused")
    @javafx.fxml.FXML
    public void toDatePicker(ActionEvent e) { e.consume(); }

    @javafx.fxml.FXML
    public void generateButton(ActionEvent actionEvent) {
        String company = companyComboBox != null ? companyComboBox.getValue() : null;
        String from    = (fromDatePicker != null && fromDatePicker.getValue() != null)
                ? fromDatePicker.getValue().toString() : null;
        String to      = (toDatePicker   != null && toDatePicker.getValue()   != null)
                ? toDatePicker.getValue().toString()   : null;

        if (xAxis != null) xAxis.setLabel("Service");
        if (yAxis != null) yAxis.setLabel("Count");

        if (checkupChart != null) {
            checkupChart.getData().clear();
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName(company != null ? company : "Company");
            // sample data
            series.getData().add(new XYChart.Data<>("Blood",  40));
            series.getData().add(new XYChart.Data<>("Vision", 28));
            series.getData().add(new XYChart.Data<>("Dental", 18));
            checkupChart.getData().add(series);
        }

        if (statusLabel != null) {
            String range = (from != null || to != null)
                    ? " (" + (from != null ? from : "") + " → " + (to != null ? to : "") + ")"
                    : "";
            statusLabel.setText("Generated chart for " + (company != null ? company : "selection") + range);
        }

        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void downloadButton(ActionEvent actionEvent) {
        String who = (companyComboBox != null && companyComboBox.getValue() != null)
                ? companyComboBox.getValue() : "selection";
        String msg = "Chart export completed at " + LocalDateTime.now();
        showInfo("Download: " + who, msg);
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
            FXMLLoader loader =
                    new FXMLLoader(HelloApplication.class.getResource("Sujarna/CorporateHealthCoordinator.fxml"));
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
