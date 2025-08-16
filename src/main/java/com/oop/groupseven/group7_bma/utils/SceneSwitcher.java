package com.oop.groupseven.group7_bma.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Utility class for switching between JavaFX scenes.
 */
public class SceneSwitcher {

    /**
     * Switch to another FXML scene.
     * @param sourceNode The node from the current scene (use `(Node) event.getSource()`).
     * @param fxmlFile   The FXML file name (must be in the resources folder).
     * @param title      The window title.
     */
    public static void switchScene(Node sourceNode, String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource("/" + fxmlFile));
            Scene newScene = new Scene(loader.load());

            Stage stage = (Stage) sourceNode.getScene().getWindow();
            stage.setScene(newScene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading FXML: " + fxmlFile);
        }
    }
}