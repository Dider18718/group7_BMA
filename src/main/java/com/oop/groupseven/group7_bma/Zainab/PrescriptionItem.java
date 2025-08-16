package com.oop.groupseven.group7_bma.Zainab;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class PrescriptionItem {
    private final StringProperty name;
    private final StringProperty dosage;
    private final StringProperty duration;
    private final StringProperty instructions;

    public PrescriptionItem(String name, String dosage, String duration, String instructions) {
        this.name = new SimpleStringProperty(name);
        this.dosage = new SimpleStringProperty(dosage);
        this.duration = new SimpleStringProperty(duration);
        this.instructions = new SimpleStringProperty(instructions);
    }

    public String getName() { return name.get(); }
    public StringProperty nameProperty() { return name; }
    public void setName(String name) { this.name.set(name); }

    public String getDosage() { return dosage.get(); }
    public StringProperty dosageProperty() { return dosage; }
    public void setDosage(String dosage) { this.dosage.set(dosage); }

    public String getDuration() { return duration.get(); }
    public StringProperty durationProperty() { return duration; }
    public void setDuration(String duration) { this.duration.set(duration); }

    public String getInstructions() { return instructions.get(); }
    public StringProperty instructionsProperty() { return instructions; }
    public void setInstructions(String instructions) { this.instructions.set(instructions); }

    @Override
    public String toString() {
        return "Medicine: " + getName() +
                "\nDosage: " + getDosage() +
                "\nDuration: " + getDuration() +
                "\nInstructions: " + getInstructions();
    }
}