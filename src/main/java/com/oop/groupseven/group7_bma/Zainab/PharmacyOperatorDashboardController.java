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

public class PharmacyOperatorDashboardController
{
    @javafx.fxml.FXML
    private BorderPane pharmacyOperatorDashboardBorderPane;
    @javafx.fxml.FXML
    private TextArea pharmacyOperatorDashboardTextArea;

    PharmacyOperatorDashboardController pharmacyOperatorDashboardController ;

    public void setter(PharmacyOperatorDashboardController pharmacyOperatorDashboardController) {
        this.pharmacyOperatorDashboardController = pharmacyOperatorDashboardController ;
        pharmacyOperatorDashboardTextArea.setText(pharmacyOperatorDashboardController.toString());
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchForMedicinButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/pharmacyOperator7_SearchForMedicine.fxml")) ;
        pharmacyOperatorDashboardBorderPane.setCenter(fxmlLoader.load());
        PharmacyOperator7_SearchForMedicineController PharmacyOperator7_SearchForMedicineController = fxmlLoader.getController() ;
        PharmacyOperator7_SearchForMedicineController.setter(this.pharmacyOperatorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void prescriptionsReceivedFromDoctorsButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/pharmacyOperator1_PrescriptionsReceivedFromDoctorsView.fxml")) ;
        pharmacyOperatorDashboardBorderPane.setCenter(fxmlLoader.load());
        PharmacyOperator1_PrescriptionsReceivedFromDoctorsViewController PharmacyOperator1_PrescriptionsReceivedFromDoctorsViewController = fxmlLoader.getController() ;
        PharmacyOperator1_PrescriptionsReceivedFromDoctorsViewController.setter(this.pharmacyOperatorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void recordOfMedicinesDispensedButtonOnAction(ActionEvent actionEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/pharmacyOperator4_RecordOfMedicineDispensedView.fxml")) ;
        pharmacyOperatorDashboardBorderPane.setCenter(fxmlLoader.load());
        PharmacyOperator4_RecordOfMedicineDispensedView PharmacyOperator4_RecordOfMedicineDispensedView = fxmlLoader.getController() ;
        PharmacyOperator4_RecordOfMedicineDispensedView.setter(this.pharmacyOperatorDashboardTextArea);
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
    public void notifyOfOutOfStockMedicinesButtonOnAction(ActionEvent actionEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/pharmacyOperator5_NotifyOfOutOfStockMedicines.fxml")) ;
        pharmacyOperatorDashboardBorderPane.setCenter(fxmlLoader.load());
        PharmacyOperator5_NotifyOfOutOfStockMedicinesController PharmacyOperator5_NotifyOfOutOfStockMedicinesController = fxmlLoader.getController() ;
        PharmacyOperator5_NotifyOfOutOfStockMedicinesController.setter(this.pharmacyOperatorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void dispenseMedicinesToPatientsButtonOnAction(ActionEvent actionEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/pharmacyOperator3_DispenseMedicinesToPatientsView.fxml")) ;
        pharmacyOperatorDashboardBorderPane.setCenter(fxmlLoader.load());
        PharmacyOperator3_DispenseMedicinesToPatientsViewController PharmacyOperator3_DispenseMedicinesToPatientsViewController = fxmlLoader.getController() ;
        PharmacyOperator3_DispenseMedicinesToPatientsViewController.setter(this.pharmacyOperatorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void verifyAuthenticityOfElectronicPrescriptionsButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/pharmacyOperator2_AuthenticityOfElectronicPrescriptionsVerification.fxml")) ;
        pharmacyOperatorDashboardBorderPane.setCenter(fxmlLoader.load());
        PharmacyOperator2_AuthenticityOfElectronicPrescriptionsVerificationController PharmacyOperator2_AuthenticityOfElectronicPrescriptionsVerificationController = fxmlLoader.getController() ;
        PharmacyOperator2_AuthenticityOfElectronicPrescriptionsVerificationController.setter(this.pharmacyOperatorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void viewExpiryDateOfMedicinesButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/pharmacyOperator6_ExpiryDateOfMedicinesView.fxml")) ;
        pharmacyOperatorDashboardBorderPane.setCenter(fxmlLoader.load());
        PharmacyOperator6_ExpiryDateOfMedicinesViewController PharmacyOperator6_ExpiryDateOfMedicinesViewController = fxmlLoader.getController() ;
        PharmacyOperator6_ExpiryDateOfMedicinesViewController.setter(this.pharmacyOperatorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void manageMedicineInventoryLevelsButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/pharmacyOperator8_Manage MedicineInventoryLevelsFrom.fxml")) ;
        pharmacyOperatorDashboardBorderPane.setCenter(fxmlLoader.load());
        PharmacyOperator8_ManageMedicineInventoryLevelsFromController PharmacyOperator8_ManageMedicineInventoryLevelsFromController = fxmlLoader.getController() ;
        PharmacyOperator8_ManageMedicineInventoryLevelsFromController.setter(this.pharmacyOperatorDashboardTextArea);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        HelloApplication.switchScene((Node) actionEvent.getSource(), "AppLauncher.fxml");
    }
}