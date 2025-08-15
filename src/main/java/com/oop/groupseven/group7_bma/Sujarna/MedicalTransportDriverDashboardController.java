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

public class MedicalTransportDriverDashboardController {
    @javafx.fxml.FXML
    public void checkMapButton(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "MedicalTransportDriverGoal3.fxml");
    }

    @javafx.fxml.FXML
    public void emergancyButton(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "MedicalTransportDriverGoal8.fxml");
    }

    @javafx.fxml.FXML
    public void endofDayButton(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "MedicalTransportDriverGoal5.fxml");
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    @javafx.fxml.FXML
    public void refuelButton(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "MedicalTransportDriverGoal2.fxml");
    }

    @javafx.fxml.FXML
    public void reportIssueButton(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "MedicalTransportDriverGoal7.fxml");
    }

    @javafx.fxml.FXML
    public void transportScheduleButton(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "MedicalTransportDriverGoal1.fxml");
    }

    @javafx.fxml.FXML
    public void tripStatusButton(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "MedicalTransportDriverGoal6.fxml");
    }

    @javafx.fxml.FXML
    public void vehicleButton(ActionEvent actionEvent) {
        navigate(actionEvent, BASE + "MedicalTransportDriverGoal4.fxml");
    }


    @SuppressWarnings("SpellCheckingInspection")
    private static final String BASE = "/com/oop/groupseven/group7_bma/Sujarna/";

    private void navigate(ActionEvent event, String fxmlPath) {
        URL url = this.getClass().getResource(fxmlPath);
        if (url == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Missing FXML");
            a.setContentText("Could not find resource: " + fxmlPath + System.lineSeparator() +
                    "Make sure it is on the classpath under src/main/resources");
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
