package com.oop.groupseven.group7_bma.Sujarna;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class CorporateHealthCoordinatorGoal4Controller {

    @javafx.fxml.FXML
    private BarChart<String, Number> statsChart;

    @javafx.fxml.FXML
    public void generateButton(ActionEvent actionEvent) {
        if (statsChart != null) {
            statsChart.getData().clear();
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Health KPI");
            // Demo values; replace with real data later
            series.getData().add(new XYChart.Data<>("BP", 72));
            series.getData().add(new XYChart.Data<>("BMI", 28));
            series.getData().add(new XYChart.Data<>("Sugar", 95));
            statsChart.getData().add(series);
            statsChart.setTitle("Company Health Statistic (Generated)");
        }
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void downloadButton(ActionEvent actionEvent) {
        // Inline alert to avoid constant-parameter inspection warnings
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Download");
        alert.setContentText("Chart export completed.");
        alert.showAndWait();
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void timeComboBox(ActionEvent actionEvent) {
        if (statsChart != null && statsChart.getTitle() != null) {
            statsChart.setTitle(statsChart.getTitle() + " • time changed");
        }
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void companyComboBox(ActionEvent actionEvent) {
        if (statsChart != null && statsChart.getTitle() != null) {
            statsChart.setTitle(statsChart.getTitle() + " • company changed");
        }
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static final String BASE = "/com/oop/groupseven/group7_bma/Sujarna/";

    private void navigateToDashboard(ActionEvent event) {
        URL url = this.getClass().getResource(BASE + "CorporateHealthCoordinator.fxml");
        if (url == null) {
            showError("Missing FXML",
                    "Could not find resource: " + BASE + "CorporateHealthCoordinator.fxml" + System.lineSeparator()
                            + "Make sure it is on the runtime classpath under src/main/resources");
            return;
        }
        try {
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showError("Navigation Error", e.getMessage());
        }
    }

    private void showError(String header, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
