package com.oop.groupseven.group7_bma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // 👇 Choose which user to start with
        // Run with:  java -Duser=admin   -> HospitalAdministrator.fxml
        //            java -Duser=psr     -> PatientSupport.fxml
        // Default (if nothing set)      -> HospitalAdministrator.fxml

        String user = System.getProperty("user", "admin").toLowerCase();

        String fxml;
        if (user.equals("psr")) {
            fxml = "Dider/PatientSupport.fxml";   // your PSR dashboard
        } else {
            fxml = "Dider/HospitalAdministrator.fxml"; // your Admin dashboard
        }

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("/" + fxml));
        Parent root = loader.load();

        stage.setTitle("Hospital Management System");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}