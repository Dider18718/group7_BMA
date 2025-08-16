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
public class MedicalTransportDriverDashboardController {

    @javafx.fxml.FXML
    public void transportScheduleButton(ActionEvent actionEvent) {
        navigate(actionEvent, "MedicalTransportDriverGoal1.fxml");
    }

    @javafx.fxml.FXML
    public void refuelButton(ActionEvent actionEvent) {
        navigate(actionEvent, "MedicalTransportDriverGoal2.fxml");
    }

    @javafx.fxml.FXML
    public void checkMapButton(ActionEvent actionEvent) {
        navigate(actionEvent, "MedicalTransportDriverGoal3.fxml");
    }

    @javafx.fxml.FXML
    public void vehicleButton(ActionEvent actionEvent) {
        navigate(actionEvent, "MedicalTransportDriverGoal4.fxml");
    }

    @javafx.fxml.FXML
    public void endofDayButton(ActionEvent actionEvent) {
        navigate(actionEvent, "MedicalTransportDriverGoal5.fxml");
    }

    @javafx.fxml.FXML
    public void tripStatusButton(ActionEvent actionEvent) {
        navigate(actionEvent, "MedicalTransportDriverGoal6.fxml");
    }

    @javafx.fxml.FXML
    public void reportIssueButton(ActionEvent actionEvent) {
        navigate(actionEvent, "MedicalTransportDriverGoal7.fxml");
    }

    @javafx.fxml.FXML
    public void emergancyButton(ActionEvent actionEvent) {
        navigate(actionEvent, "MedicalTransportDriverGoal8.fxml");
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        actionEvent.consume();
    }

    private void navigate(ActionEvent event, String fxmlName) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    HelloApplication.class.getResource("Sujarna/" + fxmlName));
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
