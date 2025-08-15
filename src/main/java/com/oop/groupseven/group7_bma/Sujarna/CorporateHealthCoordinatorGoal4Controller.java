package com.oop.groupseven.group7_bma.Sujarna;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("SpellCheckingInspection")
public class CorporateHealthCoordinatorGoal4Controller {

    @javafx.fxml.FXML private BarChart<String, Number> statsChart;

    // Matches onAction="#companyComboBox" in the FXML
    @javafx.fxml.FXML
    public void companyComboBox(ActionEvent e) {
        e.consume();               // mark the parameter as used
        // Optionally regenerate stats for the selected company:
        // generateButton();
    }

    // onAction="#generateButton" works fine with no args
    @javafx.fxml.FXML
    public void generateButton() {
        if (statsChart == null) return;
        statsChart.getData().clear();
        XYChart.Series<String, Number> s = new XYChart.Series<>();
        s.setName("Company Metrics");
        s.getData().add(new XYChart.Data<>("Employees", 125));
        s.getData().add(new XYChart.Data<>("Avg Participation %", 83.2));
        s.getData().add(new XYChart.Data<>("Complaint Rate %", 4.3));
        statsChart.getData().add(s);
        showInfo("Generated", "Stats updated on chart.");
    }

    @javafx.fxml.FXML
    public void downloadButton(ActionEvent e) {
        FileChooser fc = new FileChooser();
        fc.setInitialFileName("company_stats.csv");
        java.io.File out = fc.showSaveDialog(((Node)e.getSource()).getScene().getWindow());
        if (out == null) return;
        try (PrintWriter pw = new PrintWriter(out)) {
            pw.println("metric,value");
            pw.println("totalEmployees,125");
            pw.println("avgParticipation,83.2");
            pw.println("complaintRate,4.3");
            showInfo("Exported", "CSV saved: " + out.getName());
        } catch (Exception ex) {
            showError("Export Error", ex.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent event) { navigateToDashboard(event); }

    private void navigateToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Sujarna/CorporateHealthCoordinator.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            showError("Navigation Error", ex.getMessage());
        }
    }

    private void showInfo(String header, String message) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Info");
        a.setHeaderText(header);
        a.setContentText(message);
        a.show();
    }
    private void showError(String header, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(header);
        a.setContentText(message);
        a.showAndWait();
    }
}
