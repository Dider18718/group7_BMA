package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BedStatusController {
    @FXML private ComboBox<String> wardBox;
    @FXML private TextArea resultArea;

    @FXML private void initialize() {

        wardBox.getItems().addAll("General","ICU","Pediatrics","Maternity");
        wardBox.getSelectionModel().selectFirst();
    }
    @FXML private void load() {

        String w = wardBox.getValue();
        resultArea.setText("Ward: " + w + "\nTotal Beds: 40\nAvailable: 12\nOccupied: 28");
    }
}