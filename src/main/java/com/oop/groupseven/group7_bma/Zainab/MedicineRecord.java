package com.oop.groupseven.group7_bma.Zainab;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MedicineRecord {
    private final StringProperty medicineName;
    private final StringProperty expiryDate;
    private final StringProperty status;

    public MedicineRecord(String medicineName, String expiryDate, String status) {
        this.medicineName = new SimpleStringProperty(medicineName);
        this.expiryDate = new SimpleStringProperty(expiryDate);
        this.status = new SimpleStringProperty(status);
    }

    public String getMedicineName() { return medicineName.get(); }
    public void setMedicineName(String value) { medicineName.set(value); }
    public StringProperty medicineNameProperty() { return medicineName; }

    public String getExpiryDate() { return expiryDate.get(); }
    public void setExpiryDate(String value) { expiryDate.set(value); }
    public StringProperty expiryDateProperty() { return expiryDate; }

    public String getStatus() { return status.get(); }
    public void setStatus(String value) { status.set(value); }
    public StringProperty statusProperty() { return status; }
}
