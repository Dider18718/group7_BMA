package com.oop.groupseven.group7_bma.Zainab;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PrescriptionRecord {
    private final StringProperty time;
    private final StringProperty doctor;
    private final StringProperty patient;
    private final StringProperty status;

    public PrescriptionRecord(String time, String doctor, String patient, String status) {
        this.time = new SimpleStringProperty(time);
        this.doctor = new SimpleStringProperty(doctor);
        this.patient = new SimpleStringProperty(patient);
        this.status = new SimpleStringProperty(status);
    }

    public String getTime() { return time.get(); }
    public StringProperty timeProperty() { return time; }

    public String getDoctor() { return doctor.get(); }
    public StringProperty doctorProperty() { return doctor; }

    public String getPatient() { return patient.get(); }
    public StringProperty patientProperty() { return patient; }

    public String getStatus() { return status.get(); }
    public StringProperty statusProperty() { return status; }
    public void setStatus(String status) { this.status.set(status); }

    @Override
    public String toString() {
        return "Prescription from " + doctor.get() + " for " + patient.get() +
                " at " + time.get() + " [" + status.get() + "]";
    }
}

