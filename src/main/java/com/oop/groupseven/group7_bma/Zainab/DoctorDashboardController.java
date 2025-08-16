package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DoctorDashboardController
{
    @javafx.fxml.FXML
    private BorderPane doctorDashboardBorderPane;
    @javafx.fxml.FXML
    private TextArea doctorDashboardTextArea;


   DoctorDashboardController doctorDashboardController ;

    public void setter(DoctorDashboardController doctorDashboardController) {
        this.doctorDashboardController = doctorDashboardController ;
        doctorDashboardTextArea.setText(doctorDashboardController.toString());
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void prescriptionHistoryForAnyPatientOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/doctor8_PrescriptionHistoryForAPatientView.fxml")) ;
        doctorDashboardBorderPane.setCenter(fxmlLoader.load());
        Doctor8_PrescriptionHistoryForAPatientViewController Doctor8_PrescriptionHistoryForAPatientViewController = fxmlLoader.getController() ;
        Doctor8_PrescriptionHistoryForAPatientViewController.setter(this.doctorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void accessPatientMedicalHistoryOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/doctor3_AccessPatientMedicalHistory.fxml")) ;
        doctorDashboardBorderPane.setCenter(fxmlLoader.load());
        Doctor3_AccessPatientMedicalHistoryController Doctor3_AccessPatientMedicalHistoryController = fxmlLoader.getController() ;
        Doctor3_AccessPatientMedicalHistoryController.setter(this.doctorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void updatePatientTreatmentDetailsOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/doctor5_UpdatePatientTreatmentDetails.fxml")) ;
        doctorDashboardBorderPane.setCenter(fxmlLoader.load());
        Doctor5_UpdatePatientTreatmentDetailsController Doctor5_UpdatePatientTreatmentDetailsController = fxmlLoader.getController() ;
        Doctor5_UpdatePatientTreatmentDetailsController.setter(this.doctorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void createAndIssuePrescriptionsOnAction(ActionEvent actionEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/doctor7_CreateAndIssuePrescriptionsFrom.fxml")) ;
        doctorDashboardBorderPane.setCenter(fxmlLoader.load());
        Doctor7_CreateAndIssuePrescriptionsFromController Doctor7_CreateAndIssuePrescriptionsFromController = fxmlLoader.getController() ;
        Doctor7_CreateAndIssuePrescriptionsFromController.setter(this.doctorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void addNewDiagonosisToAPatientsRecordOnAction(ActionEvent actionEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/doctor4_AddNewDiagnosisToAPatientsRecordFrom.fxml")) ;
        doctorDashboardBorderPane.setCenter(fxmlLoader.load());
        Doctor4_AddNewDiagnosisToAPatientsRecordFromController Doctor4_AddNewDiagnosisToAPatientsRecordFromController = fxmlLoader.getController() ;
        Doctor4_AddNewDiagnosisToAPatientsRecordFromController.setter(this.doctorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(""));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
    }

    @javafx.fxml.FXML
    public void recommendDiagnosticTestsOnAction(ActionEvent actionEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/doctor6_RecommendDiagnosticTestsFrom.fxml")) ;
        doctorDashboardBorderPane.setCenter(fxmlLoader.load());
        Doctor6_RecommendDiagnosticTestsFromController Doctor6_RecommendDiagnosticTestsFromController = fxmlLoader.getController() ;
        Doctor6_RecommendDiagnosticTestsFromController.setter(this.doctorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void patientsListForTheDayOnAction(ActionEvent actionEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/doctor1_AssignedPatientListView.fxml")) ;
        doctorDashboardBorderPane.setCenter(fxmlLoader.load());
        Doctor1_AssignedPatientListViewController Doctor1_AssignedPatientListViewController = fxmlLoader.getController() ;
        Doctor1_AssignedPatientListViewController.setter(this.doctorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void personalScheduleAndAppointmentsOnAction(ActionEvent actionEvent)   throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/doctor2_PersonalScheduleandAppointmentsView.fxml")) ;
        doctorDashboardBorderPane.setCenter(fxmlLoader.load());
        Doctor2_PersonalScheduleandAppointmentsViewController Doctor2_PersonalScheduleandAppointmentsViewController = fxmlLoader.getController() ;
        Doctor2_PersonalScheduleandAppointmentsViewController.setter(this.doctorDashboardTextArea);
    }
}