package com.oop.groupseven.group7_bma.Shibli;

import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.awt.*;
import java.awt.event.ActionEvent;

public class RoomAvailabilityViewController
{
    @javafx.fxml.FXML
    private RadioButton availableRadio;
    @javafx.fxml.FXML
    private ComboBox roomCombo;
    @javafx.fxml.FXML
    private ToggleGroup availabilityGroup;
    @javafx.fxml.FXML
    private TextField reasonField;
    @javafx.fxml.FXML
    private RadioButton unavailableRadio;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSubmit(ActionEvent actionEvent) {
    }
}