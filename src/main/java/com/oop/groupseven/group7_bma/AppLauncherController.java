package com.oop.groupseven.group7_bma;

import javafx.event.ActionEvent;
import javafx.scene.Node;

public class AppLauncherController {

    @javafx.fxml.FXML
    private void patientButton(ActionEvent e) {
        HelloApplication.switchScene((Node) e.getSource(), "Shibli/PatientDashboardView.fxml");
    }

    @javafx.fxml.FXML
    private void medicalInspectorButton(ActionEvent e) {
        HelloApplication.switchScene((Node) e.getSource(), "Shibli/MedicalInspectorDashboard.fxml");
    }

    @javafx.fxml.FXML
    private void administratorButton(ActionEvent e) {
        HelloApplication.switchScene((Node) e.getSource(), "Dider/hospitalAdministrator.fxml");
    }

    @javafx.fxml.FXML
    private void patientSupportButton(ActionEvent e) {
        HelloApplication.switchScene((Node) e.getSource(), "Dider/PatientSupport.fxml");
    }

    @javafx.fxml.FXML
    private void doctorButton(ActionEvent e) {
        HelloApplication.switchScene((Node) e.getSource(), "Zainab/doctorDashboard.fxml");
    }

    @javafx.fxml.FXML
    private void pharmacyButton(ActionEvent e) {
        HelloApplication.switchScene((Node) e.getSource(), "Zainab/pharmacyOperatorDashboard.fxml");
    }

    @javafx.fxml.FXML
    private void coordinatorButton(ActionEvent e) {
        HelloApplication.switchScene((Node) e.getSource(), "Sujarna/CorporateHealthCoordinator.fxml");
    }

    @javafx.fxml.FXML
    private void transportButton(ActionEvent e) {
        HelloApplication.switchScene((Node) e.getSource(), "Sujarna/MedicalTransportDriverDashboard.fxml");
    }
}
