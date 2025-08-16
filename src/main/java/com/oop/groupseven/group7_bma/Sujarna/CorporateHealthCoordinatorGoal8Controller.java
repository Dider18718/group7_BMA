package com.oop.groupseven.group7_bma.Sujarna;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings({ "SpellCheckingInspection", "CanBeFinal" })
public class CorporateHealthCoordinatorGoal8Controller {

    // Defaults keep IntelliJ quiet about “never assigned”; FXML will still inject at runtime.
    @javafx.fxml.FXML private ComboBox<String> eventComboBox   = new ComboBox<>();
    @javafx.fxml.FXML private ComboBox<String> ratingComboBox  = new ComboBox<>();
    @javafx.fxml.FXML private CheckBox         anonymousCheck  = new CheckBox("Submit anonymously");
    @javafx.fxml.FXML private TextArea         feedbackTextArea = new TextArea();
    @javafx.fxml.FXML private ListView<String> feedbackListView = new ListView<>();
    @javafx.fxml.FXML private Label            statusLabel       = new Label();

    @javafx.fxml.FXML
    public void initialize() {
        // Seed rating options if FXML didn’t provide them
        if (ratingComboBox.getItems().isEmpty()) {
            ratingComboBox.getItems().addAll(List.of("1", "2", "3", "4", "5"));
        }
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String event   = (eventComboBox  != null) ? eventComboBox.getValue()  : null;
        String rating  = (ratingComboBox != null) ? ratingComboBox.getValue() : null;
        String comment = (feedbackTextArea != null) ? feedbackTextArea.getText() : null;
        boolean anon   = (anonymousCheck != null) && anonymousCheck.isSelected();

        if (event == null || event.isBlank() ||
                rating == null || rating.isBlank() ||
                comment == null || comment.isBlank()) {
            showError("Missing data", "Please select Event and Rating, and enter feedback text.");
            actionEvent.consume();
            return;
        }

        String entry = String.format("[%s] Event=%s, Rating=%s%s, Comment=%s",
                LocalDateTime.now(),
                event,
                rating,
                anon ? " (anonymous)" : "",
                comment);

        if (feedbackListView != null) {
            feedbackListView.getItems().add(entry);
            feedbackListView.scrollTo(feedbackListView.getItems().size() - 1);
        }
        if (statusLabel != null) {
            statusLabel.setText("Feedback submitted for " + event + " (rating: " + rating + ")");
        }

        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        if (eventComboBox != null)  eventComboBox.getSelectionModel().clearSelection();
        if (ratingComboBox != null) ratingComboBox.getSelectionModel().clearSelection();
        if (feedbackTextArea != null) feedbackTextArea.clear();
        if (anonymousCheck != null) anonymousCheck.setSelected(false);
        if (statusLabel != null) statusLabel.setText("Cleared");
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    // ---------------- helpers ----------------

    private void showError(String header, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(header);
        a.setContentText(message);
        a.showAndWait();
    }

    private void navigateToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(HelloApplication.class.getResource("Sujarna/CorporateHealthCoordinator.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showError("Navigation Error", e.getMessage());
        }
    }
}
