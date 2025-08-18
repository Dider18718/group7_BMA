package com.oop.groupseven.group7_bma.Shibli;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.time.LocalDateTime;
import java.util.Objects;

public class DailyInspectionFormViewController {

    @javafx.fxml.FXML private TextField roomIdField;
    @javafx.fxml.FXML private ComboBox<String> oxygenField;
    @javafx.fxml.FXML private ComboBox<String> bedField;
    @javafx.fxml.FXML private ComboBox<String> ventilatorField;
    @javafx.fxml.FXML private TextArea notesArea;

    @javafx.fxml.FXML
    private void saveInspection(ActionEvent e) {
        String room = val(roomIdField);
        String oxy  = val(oxygenField);
        String bed  = val(bedField);
        String vent = val(ventilatorField);
        String note = notesArea == null ? "" : notesArea.getText();

        if (room.isBlank() || oxy.isBlank() || bed.isBlank() || vent.isBlank()) {
            show(Alert.AlertType.ERROR, "Missing data", "Please fill Room ID and all statuses.");
            e.consume();
            return;
        }

        // Minimal “save”: just show a confirmation (you can wire to BinStorage later)
        String msg = """
                Saved at: %s
                Room: %s
                Oxygen: %s | Bed: %s | Ventilator: %s
                Notes: %s
                """.formatted(LocalDateTime.now(), room, oxy, bed, vent, note);
        show(Alert.AlertType.INFORMATION, "Daily inspection saved successfully.", msg);
        e.consume();
    }

    @javafx.fxml.FXML
    private void cancel(ActionEvent e) {
        // go back to the Patient dashboard (or inspector — your choice)
        HelloApplication.switchScene((Node) e.getSource(), "Shibli/PatientDashboardView.fxml");
    }

    private static String val(TextInputControl c) {
        return c == null || c.getText() == null ? "" : c.getText().trim();
    }

    private static String val(ComboBox<String> c) {
        return c == null || c.getValue() == null ? "" : c.getValue().trim();
    }

    private void show(Alert.AlertType type, String header, String msg) {
        Alert a = new Alert(type);
        a.setTitle(type == Alert.AlertType.ERROR ? "Error" : "Info");
        a.setHeaderText(header);
        a.setContentText(msg);
        a.showAndWait();
    }
}
