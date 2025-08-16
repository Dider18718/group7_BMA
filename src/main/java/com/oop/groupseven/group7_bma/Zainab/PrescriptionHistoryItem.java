package com.oop.groupseven.group7_bma.Zainab;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class PrescriptionHistoryItem {
    private final StringProperty date;
    private final StringProperty medicine;
    private final StringProperty dosage;

    public PrescriptionHistoryItem(String date, String medicine, String dosage) {
        this.date = new SimpleStringProperty(date);
        this.medicine = new SimpleStringProperty(medicine);
        this.dosage = new SimpleStringProperty(dosage);
    }

    public String getDate() { return date.get(); }
    public StringProperty dateProperty() { return date; }

    public String getMedicine() { return medicine.get(); }
    public StringProperty medicineProperty() { return medicine; }

    public String getDosage() { return dosage.get(); }
    public StringProperty dosageProperty() { return dosage; }
}
