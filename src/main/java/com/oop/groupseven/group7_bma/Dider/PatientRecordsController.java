package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PatientRecordsController {
    @FXML private TextField patientIdField;
    @FXML private TextArea resultArea;

    @FXML private void search() {

        String id = patientIdField.getText().trim();

        if (id.isEmpty()) { resultArea.setText("Enter a Patient ID."); return; }

        resultArea.setText("Patient ID: " + id + "\nName: John Doe\nAge: 45\nDiagnosis: Hypertension\nLast Visit: 2025-07-10");
    }
}