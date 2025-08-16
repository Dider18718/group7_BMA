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

    @javafx.fxml.FXML private TextField serviceField  = new TextField();
    @javafx.fxml.FXML private TextField priceField    = new TextField();
    @javafx.fxml.FXML private TextField durationField = new TextField();

    @javafx.fxml.FXML private TableView<StatRow> statsTable = new TableView<>();
    @javafx.fxml.FXML private TableColumn<StatRow, String> serviceCol = new TableColumn<>("Service");
    @javafx.fxml.FXML private TableColumn<StatRow, Number> priceCol   = new TableColumn<>("Price");
    @javafx.fxml.FXML private TableColumn<StatRow, Number> durationCol = new TableColumn<>("Duration");

    @javafx.fxml.FXML private Label statusLabel = new Label();

    private final ObservableList<StatRow> rows = FXCollections.observableArrayList();

    // ===== Compatibility handlers for FXML onAction="#<fx:id>" =====
    @javafx.fxml.FXML public void serviceField(ActionEvent e)  { e.consume(); }
    @javafx.fxml.FXML public void priceField(ActionEvent e)    { e.consume(); }
    @javafx.fxml.FXML public void durationField(ActionEvent e) { e.consume(); }
    // ===============================================================

    @javafx.fxml.FXML
    public void initialize() {
        serviceCol.setCellValueFactory(new PropertyValueFactory<>("service"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));

        if (!statsTable.getColumns().contains(serviceCol))  statsTable.getColumns().add(serviceCol);
        if (!statsTable.getColumns().contains(priceCol))    statsTable.getColumns().add(priceCol);
        if (!statsTable.getColumns().contains(durationCol)) statsTable.getColumns().add(durationCol);

        statsTable.setItems(rows);
        statsTable.getSelectionModel().selectedItemProperty().addListener((obs, o, s) -> {
            if (s != null) {
                serviceField.setText(s.getService());
                priceField.setText(Double.toString(s.getPrice()));
                durationField.setText(Integer.toString(s.getDuration()));
            }
        });
    }

    @javafx.fxml.FXML
    public void addButton(ActionEvent actionEvent) {
        String svc = trimOrNull(serviceField.getText());
        Double pr  = parseDouble(priceField.getText(), "Price");
        Integer du = parseInt(durationField.getText(), "Duration (minutes)");
        if (svc == null || pr == null || du == null) { actionEvent.consume(); return; }
        rows.add(new StatRow(svc, pr, du));
        setStatus("Added: " + svc + " (price=" + pr + ", duration=" + du + "m)");
        clearInputs(); actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void updateButton(ActionEvent actionEvent) {
        StatRow s = statsTable.getSelectionModel().getSelectedItem();
        if (s == null) { showError("No selection", "Select a row to update."); actionEvent.consume(); return; }
        String svc = trimOrNull(serviceField.getText());
        Double pr  = parseDouble(priceField.getText(), "Price");
        Integer du = parseInt(durationField.getText(), "Duration (minutes)");
        if (svc == null || pr == null || du == null) { actionEvent.consume(); return; }
        s.setService(svc); s.setPrice(pr); s.setDuration(du);
        statsTable.refresh(); setStatus("Updated: " + svc); actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void deleteButton(ActionEvent actionEvent) {
        StatRow s = statsTable.getSelectionModel().getSelectedItem();
        if (s == null) { showError("No selection", "Select a row to delete."); actionEvent.consume(); return; }
        rows.remove(s); setStatus("Deleted: " + s.getService()); actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        clearInputs(); setStatus("Cleared"); actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    // ----- helpers -----
    private void clearInputs() { serviceField.clear(); priceField.clear(); durationField.clear(); statsTable.getSelectionModel().clearSelection(); }
    private void setStatus(String t) { if (statusLabel != null) statusLabel.setText(t); }
    private String trimOrNull(String s) { if (s == null) return null; String t = s.trim(); return t.isEmpty()? null : t; }

    private Double parseDouble(String s, String field) {
        try { return Double.parseDouble(trimOrNull(s)); }
        catch (Exception e) { showError("Invalid number", field + " must be a valid number."); return null; }
    }

    private Integer parseInt(String s, String field) {
        try { return Integer.parseInt(trimOrNull(s)); }
        catch (Exception e) { showError("Invalid number", field + " must be an integer."); return null; }
    }

    private void showError(String h, String m) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error"); a.setHeaderText(h); a.setContentText(m); a.showAndWait();
    }

    private void navigateToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Sujarna/CorporateHealthCoordinator.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root)); stage.show();
        } catch (IOException e) { showError("Navigation Error", e.getMessage()); }
    }

    // table model
    public static class StatRow {
        private final SimpleStringProperty service = new SimpleStringProperty();
        private final SimpleDoubleProperty price   = new SimpleDoubleProperty();
        private final SimpleIntegerProperty duration = new SimpleIntegerProperty();
        public StatRow(String s, double p, int d) { service.set(s); price.set(p); duration.set(d); }
        public String getService() { return service.get(); }
        public double getPrice()   { return price.get(); }
        public int getDuration()   { return duration.get(); }
        public void setService(String v) { service.set(v); }
        public void setPrice(double v)   { price.set(v); }
        public void setDuration(int v)   { duration.set(v); }
    }
}
