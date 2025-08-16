package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Doctor1_AssignedPatientListViewController
{
    @javafx.fxml.FXML
    private TableColumn colPatientName;
    @javafx.fxml.FXML
    private TextField quickSearchTextField;
    @javafx.fxml.FXML
    private TableColumn colDepartmentOrReason;
    @javafx.fxml.FXML
    private TableColumn colAppointmentTime;
    @javafx.fxml.FXML
    private TableView patientTableView;
    @javafx.fxml.FXML
    private TableColumn colPatientID;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void fetchListButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void startConsultationButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
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

    @javafx.fxml.FXML
    public void selectDatePickerOnAction(ActionEvent actionEvent) {
    }
}