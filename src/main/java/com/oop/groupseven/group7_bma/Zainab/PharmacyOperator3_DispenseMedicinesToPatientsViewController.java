package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PharmacyOperator3_DispenseMedicinesToPatientsViewController {
    @javafx.fxml.FXML
    private TextField perscriptionIDTextField;
    @javafx.fxml.FXML
    private Label availabilityStatusLabel;
    @javafx.fxml.FXML
    private TextField searchMedicineTextField;

    @javafx.fxml.FXML
    public void markAsDispensedButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/pharmacyOperatorDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Pharmacy Operator Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void printLabelButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void collectPackageButtonOnAction(ActionEvent actionEvent) {
    }




    PharmacyOperatorDashboardController PharmacyOperatorDashboardController ;

    public void setter(TextArea pharmacyOperatorTextArea) { this.PharmacyOperatorDashboardController = PharmacyOperatorDashboardController ;
    }
}
