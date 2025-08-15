package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class Doctor6_RecommendDiagnosticTestsFromController {
    @javafx.fxml.FXML
    private TextArea notesTextArea;
    @javafx.fxml.FXML
    private ComboBox listOfTestsComboBox;
    @javafx.fxml.FXML
    private ComboBox urgencyLevelComboBox;

    @javafx.fxml.FXML
    public void submitRecommendationButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/doctorDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Doctor Dashboard");
        stage.show();
    }

    DoctorDashboardController DoctorDashboardController ;

    public void setter(TextArea doctorDashboardTextArea) { this.DoctorDashboardController = DoctorDashboardController ; }
}
