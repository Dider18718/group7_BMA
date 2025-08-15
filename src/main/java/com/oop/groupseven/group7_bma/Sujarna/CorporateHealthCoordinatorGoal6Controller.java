package com.oop.groupseven.group7_bma.Sujarna;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CorporateHealthCoordinatorGoal6Controller implements Initializable {

    @javafx.fxml.FXML private TextArea serviceTextArea;
    @javafx.fxml.FXML private TableColumn<PackageRow, String> pNameTableView;
    @javafx.fxml.FXML private TableView<PackageRow> packageTable;
    @javafx.fxml.FXML private TextField durationTextField;
    @javafx.fxml.FXML private TextField nameTextField;
    @javafx.fxml.FXML private TableColumn<PackageRow, String> durationTableView;
    @javafx.fxml.FXML private TableColumn<PackageRow, String> priceTableView;
    @javafx.fxml.FXML private TextField priceTextField;
    @javafx.fxml.FXML private TableColumn<PackageRow, String> serviceTableView;
    @javafx.fxml.FXML private Label confirmationLabel;

    public static class PackageRow {
        private final SimpleStringProperty name = new SimpleStringProperty();
        private final SimpleStringProperty service = new SimpleStringProperty();
        private final SimpleStringProperty price = new SimpleStringProperty();
        private final SimpleStringProperty duration = new SimpleStringProperty();

        public PackageRow(String name, String service, String price, String duration) {
            this.name.set(name);
            this.service.set(service);
            this.price.set(price);
            this.duration.set(duration);
        }
        public String getName() { return name.get(); }
        public String getService() { return service.get(); }
        public String getPrice() { return price.get(); }
        public String getDuration() { return duration.get(); }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (packageTable != null && packageTable.getItems() == null) {
            packageTable.setItems(FXCollections.observableArrayList());
        }
        if (pNameTableView != null) {
            pNameTableView.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getName()));
        }
        if (serviceTableView != null) {
            serviceTableView.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getService()));
        }
        if (priceTableView != null) {
            priceTableView.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getPrice()));
        }
        if (durationTableView != null) {
            durationTableView.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getDuration()));
        }
    }

    @javafx.fxml.FXML
    public void addEditButton(ActionEvent actionEvent) {
        String name = nameTextField != null ? nameTextField.getText() : null;
        String service = serviceTextArea != null ? serviceTextArea.getText() : null;
        String price = priceTextField != null ? priceTextField.getText() : null;
        String duration = durationTextField != null ? durationTextField.getText() : null;

        if (packageTable != null) {
            packageTable.getItems().add(new PackageRow(name, service, price, duration));
        }
        if (confirmationLabel != null) confirmationLabel.setText("Saved package: " + name);
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        if (nameTextField != null) nameTextField.clear();
        if (serviceTextArea != null) serviceTextArea.clear();
        if (priceTextField != null) priceTextField.clear();
        if (durationTextField != null) durationTextField.clear();
        if (confirmationLabel != null) confirmationLabel.setText("Cleared");
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
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Missing FXML");
            a.setContentText("Could not find resource: " + BASE + "CorporateHealthCoordinator.fxml" + System.lineSeparator()
                    + "Make sure it is on the classpath under src/main/resources");
            a.showAndWait();
            return;
        }
        try {
            Parent root = FXMLLoader.load(url);
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
