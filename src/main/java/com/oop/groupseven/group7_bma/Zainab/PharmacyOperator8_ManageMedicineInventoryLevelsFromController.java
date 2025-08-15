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

public class PharmacyOperator8_ManageMedicineInventoryLevelsFromController {
    @javafx.fxml.FXML
    private TableColumn colQuantity;
    @javafx.fxml.FXML
    private TableColumn colMedicineName;
    @javafx.fxml.FXML
    private TableColumn colThreshold;

    @javafx.fxml.FXML
    public void recordReceivedItemsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveRestockButtonOnAction(ActionEvent actionEvent) {
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
    public void setRecordThersholdButtonOnAction(ActionEvent actionEvent) {
    }



    PharmacyOperatorDashboardController PharmacyOperatorDashboardController ;

    public void setter(TextArea pharmacyOperatorTextArea) { this.PharmacyOperatorDashboardController = PharmacyOperatorDashboardController ;
    }
}
