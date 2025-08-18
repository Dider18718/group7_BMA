package com.oop.groupseven.group7_bma.Sujarna;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class CorporateHealthCoordinatorController {

    // Goal entries — every handler uses the ActionEvent
    @javafx.fxml.FXML
    public void corporateHealthReport(ActionEvent actionEvent) {
        navigate(actionEvent, "CorporateHealthCoordinatorGoal1.fxml");
    }

    @javafx.fxml.FXML
    public void healthPackageListing(ActionEvent actionEvent) {
        navigate(actionEvent, "CorporateHealthCoordinatorGoal2.fxml");
    }

    @javafx.fxml.FXML
    public void assignStaffOtEvent(ActionEvent actionEvent) {
        navigate(actionEvent, "CorporateHealthCoordinatorGoal3.fxml");
    }

    @javafx.fxml.FXML
    public void healthCheckupButton(ActionEvent actionEvent) {
        navigate(actionEvent, "CorporateHealthCoordinatorGoal4.fxml");
    }

    @javafx.fxml.FXML
    public void companyHealthQueries(ActionEvent actionEvent) {
        navigate(actionEvent, "CorporateHealthCoordinatorGoal5.fxml");
    }

    @javafx.fxml.FXML
    public void companyHealthStats(ActionEvent actionEvent) {
        navigate(actionEvent, "CorporateHealthCoordinatorGoal6.fxml");
    }

    @javafx.fxml.FXML
    public void trackParticipationRate(ActionEvent actionEvent) {
        navigate(actionEvent, "CorporateHealthCoordinatorGoal7.fxml");
    }

    @javafx.fxml.FXML
    public void postEventFeedback(ActionEvent actionEvent) {
        navigate(actionEvent, "CorporateHealthCoordinatorGoal8.fxml");
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
        // Uses the event; satisfies the inspection and closes the window
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        actionEvent.consume();
    }

    /** Centralized navigation helper (no java.net.URL import needed). */
    private void navigate(ActionEvent event, String fxmlName) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(HelloApplication.class.getResource("Sujarna/" + fxmlName));
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

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        HelloApplication.switchScene((Node) actionEvent.getSource(), "AppLauncher.fxml");
    }
}
