package com.oop.groupseven.group7_bma.Shibli;

import com.oop.groupseven.group7_bma.storage.BinStorage;
import com.oop.groupseven.group7_bma.storage.InspectionRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class DailyInspectionFormViewController {

    @FXML
    private TextField roomIdField;

    @FXML
    private TextField oxygenField;

    @FXML
    private TextField bedField;

    @FXML
    private TextField ventilatorField;

    @FXML
    private TextArea notesArea;

    // ✅ Save inspection to .bin file
    @FXML
    public void saveInspection(ActionEvent event) {
        InspectionRecord rec = new InspectionRecord(
                LocalDate.now(),
                roomIdField.getText(),
                oxygenField.getText(),
                bedField.getText(),
                ventilatorField.getText(),
                notesArea.getText()
        );
        BinStorage.saveRecord(rec);
        System.out.println("✅ Inspection saved to inspections.bin");
    }

    // ✅ Clear form fields
    @FXML
    public void clearForm(ActionEvent event) {
        roomIdField.clear();
        oxygenField.clear();
        bedField.clear();
        ventilatorField.clear();
        notesArea.clear();
    }

    // ✅ Go back to dashboard
    @FXML
    public void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(
                    "/com/oop/groupseven/group7_bma/Shibli/MedicalInspectorDashboardView.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Inspector Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
