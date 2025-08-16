package com.oop.groupseven.group7_bma.Zainab;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MedicineInventory {
    private final StringProperty medicineName;
    private final IntegerProperty quantity;
    private final IntegerProperty threshold;

    public MedicineInventory(String medicineName, int quantity, int threshold) {
        this.medicineName = new SimpleStringProperty(medicineName);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.threshold = new SimpleIntegerProperty(threshold);
    }

    public String getMedicineName() { return medicineName.get(); }
    public void setMedicineName(String value) { medicineName.set(value); }
    public StringProperty medicineNameProperty() { return medicineName; }

    public int getQuantity() { return quantity.get(); }
    public void setQuantity(int value) { quantity.set(value); }
    public IntegerProperty quantityProperty() { return quantity; }

    public int getThreshold() { return threshold.get(); }
    public void setThreshold(int value) { threshold.set(value); }
    public IntegerProperty thresholdProperty() { return threshold; }
}

