package com.oop.groupseven.group7_bma.Shibli;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.awt.event.ActionEvent;

public class PrescriptionHistoryViewController
{
    @javafx.fxml.FXML
    private TableColumn actionColumn;
    @javafx.fxml.FXML
    private TableView prescriptionTable;
    @javafx.fxml.FXML
    private TableColumn doctorColumn;
    @javafx.fxml.FXML
    private TableColumn summaryColumn;
    @javafx.fxml.FXML
    private TableColumn dateColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBackAction(ActionEvent actionEvent) {
    }
}