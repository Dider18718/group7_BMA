package com.oop.groupseven.group7_bma.Zainab;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class PrescriptionItem {
    private String medicineName;
    private String dosage;
    private String duration;
    private String usageInstruction;

    public PrescriptionItem(String medicineName, String dosage, String duration, String usageInstruction) {
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.duration = duration;
        this.usageInstruction = usageInstruction;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public String getDuration() {
        return duration;
    }

    public String getUsageInstruction() {
        return usageInstruction;
    }

    @Override
    public String toString() {
        return medicineName + " - " + dosage + " - " + duration;
    }
}
