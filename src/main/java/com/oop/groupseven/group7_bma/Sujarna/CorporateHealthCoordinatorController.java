package com.oop.groupseven.group7_bma.Sujarna;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class CorporateHealthCoordinatorController {

    @SuppressWarnings("SpellCheckingInspection")
    private static final String BASE = "/com/oop/groupseven/group7_bma/Sujarna/";

    private void navigate(ActionEvent event, String fxmlPath) {
        URL url = CorporateHealthCoordinatorController.class.getResource(fxmlPath);
        if (url == null) {
            showError("Missing FXML",
                    "Could not find resource: " + fxmlPath +
                            "\nMake sure it is on the runtime classpath under src/main/resources");
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

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    @javafx.fxml.FXML
    public void postEventFeedback(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "CorporateHealthCoordinatorGoal8.fxml");
    }

    @javafx.fxml.FXML
    public void trackParticipationRate(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "CorporateHealthCoordinatorGoal7.fxml");
    }

    @javafx.fxml.FXML
    public void companyHealthStats(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "CorporateHealthCoordinatorGoal6.fxml");
    }

    @javafx.fxml.FXML
    public void companyHealthQueries(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "CorporateHealthCoordinatorGoal5.fxml");
    }

    @javafx.fxml.FXML
    public void healthCheckupButton(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "CorporateHealthCoordinatorGoal4.fxml");
    }

    @javafx.fxml.FXML
    public void assignStaffOtEvent(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "CorporateHealthCoordinatorGoal3.fxml");
    }

    @javafx.fxml.FXML
    public void healthPackageListing(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "CorporateHealthCoordinatorGoal2.fxml");
    }

    @javafx.fxml.FXML
    public void corporateHealthReport(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "CorporateHealthCoordinatorGoal1.fxml");
    }
}

