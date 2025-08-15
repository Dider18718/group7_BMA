package com.oop.groupseven.group7_bma.Sujarna;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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

@SuppressWarnings({ "SpellCheckingInspection", "CanBeFinal" })
public class CorporateHealthCoordinatorGoal6Controller {

    // Inputs
    @javafx.fxml.FXML private TextField serviceField = new TextField();
    @javafx.fxml.FXML private TextField priceField   = new TextField();
    @javafx.fxml.FXML private TextField durationField = new TextField();

    // Table + columns
    @javafx.fxml.FXML private TableView<StatRow> statsTable = new TableView<>();
    @javafx.fxml.FXML private TableColumn<StatRow, String> serviceCol = new TableColumn<>("Service");
    @javafx.fxml.FXML private TableColumn<StatRow, Number> priceCol   = new TableColumn<>("Price");
    @javafx.fxml.FXML private TableColumn<StatRow, Number> durationCol = new TableColumn<>("Duration");

    // Status label
    @javafx.fxml.FXML private Label statusLabel = new Label();

    private final ObservableList<StatRow> rows = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Wire columns to model getters
        serviceCol.setCellValueFactory(new PropertyValueFactory<>("service"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));

        if (!statsTable.getColumns().contains(serviceCol)) statsTable.getColumns().add(serviceCol);
        if (!statsTable.getColumns().contains(priceCol))   statsTable.getColumns().add(priceCol);
        if (!statsTable.getColumns().contains(durationCol)) statsTable.getColumns().add(durationCol);

        statsTable.setItems(rows);
        statsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, sel) -> {
            if (sel != null) {
                serviceField.setText(sel.getService());
                priceField.setText(Double.toString(sel.getPrice()));
                durationField.setText(Integer.toString(sel.getDuration()));
            }
        });
    }

    @javafx.fxml.FXML
    public void addButton(ActionEvent actionEvent) {
        String service = trimOrNull(serviceField.getText());
        Double price   = parseDouble(priceField.getText(), "Price");
        Integer dur    = parseInt(durationField.getText(), "Duration (minutes)");
        if (service == null || price == null || dur == null) {
            actionEvent.consume();
            return;
        }
        rows.add(new StatRow(service, price, dur));
        setStatus("Added: " + service + " (price=" + price + ", duration=" + dur + "m)");
        clearInputs();
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void updateButton(ActionEvent actionEvent) {
        StatRow sel = statsTable.getSelectionModel().getSelectedItem();
        if (sel == null) {
            showError("No selection", "Select a row to update.");
            actionEvent.consume();
            return;
        }
        String service = trimOrNull(serviceField.getText());
        Double price   = parseDouble(priceField.getText(), "Price");
        Integer dur    = parseInt(durationField.getText(), "Duration (minutes)");
        if (service == null || price == null || dur == null) {
            actionEvent.consume();
            return;
        }
        sel.setService(service);
        sel.setPrice(price);
        sel.setDuration(dur);
        statsTable.refresh();
        setStatus("Updated: " + service);
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void deleteButton(ActionEvent actionEvent) {
        StatRow sel = statsTable.getSelectionModel().getSelectedItem();
        if (sel == null) {
            showError("No selection", "Select a row to delete.");
            actionEvent.consume();
            return;
        }
        rows.remove(sel);
        setStatus("Deleted: " + sel.getService());
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        clearInputs();
        setStatus("Cleared");
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    // ---------- helpers ----------

    private void clearInputs() {
        serviceField.clear();
        priceField.clear();
        durationField.clear();
        statsTable.getSelectionModel().clearSelection();
    }

    private void setStatus(String text) {
        if (statusLabel != null) statusLabel.setText(text);
    }

    private String trimOrNull(String s) {
        if (s == null) return null;
        String t = s.trim();
        return t.isEmpty() ? null : t;
    }

    private Double parseDouble(String s, String fieldName) {
        try {
            return Double.parseDouble(trimOrNull(s));
        } catch (Exception e) {
            showError("Invalid number", fieldName + " must be a valid number.");
            return null;
        }
    }

    private Integer parseInt(String s, String fieldName) {
        try {
            return Integer.parseInt(trimOrNull(s));
        } catch (Exception e) {
            showError("Invalid number", fieldName + " must be an integer.");
            return null;
        }
    }

    private void showError(String header, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
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
            showError("Navigation Error", e.getMessage());
        }
    }

    // ---------- table row model ----------
    public static class StatRow {
        private final SimpleStringProperty service = new SimpleStringProperty();
        private final SimpleDoubleProperty price   = new SimpleDoubleProperty();
        private final SimpleIntegerProperty duration = new SimpleIntegerProperty();

        public StatRow(String service, double price, int duration) {
            this.service.set(service);
            this.price.set(price);
            this.duration.set(duration);
        }

        public String getService()   { return service.get(); }
        public double getPrice()     { return price.get(); }
        public int getDuration()     { return duration.get(); }

        public void setService(String s)   { service.set(s); }
        public void setPrice(double p)     { price.set(p); }
        public void setDuration(int d)     { duration.set(d); }
    }
}
