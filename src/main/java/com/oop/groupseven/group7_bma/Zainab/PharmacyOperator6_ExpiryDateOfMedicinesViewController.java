package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class PharmacyOperator6_ExpiryDateOfMedicinesViewController {
    @javafx.fxml.FXML
    private TableColumn colExpiryDate;
    @javafx.fxml.FXML
    private TableColumn colMedicine;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent)throws IOException {
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
    public void markAsDisposalButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void tagAsCriticalButtonOnAction(ActionEvent actionEvent) {
    }



    PharmacyOperatorDashboardController PharmacyOperatorDashboardController ;

    public void setter(TextArea pharmacyOperatorTextArea) { this.PharmacyOperatorDashboardController = PharmacyOperatorDashboardController ;
    }
}
