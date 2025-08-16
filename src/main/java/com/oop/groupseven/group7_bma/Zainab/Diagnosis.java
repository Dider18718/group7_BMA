package com.oop.groupseven.group7_bma.Zainab;

public class Diagnosis {
    private String symptoms;
    private String diagnosisName;
    private String severity;
    private String notes;



    public Diagnosis(String symptoms, String diagnosisName, String severity, String notes) {
        this.symptoms = symptoms;
        this.diagnosisName = diagnosisName;
        this.severity = severity;
        this.notes = notes;
    }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getDiagnosisName() { return diagnosisName; }
    public void setDiagnosisName(String diagnosisName) { this.diagnosisName = diagnosisName; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public String toString() {
        return "Diagnosis: " + diagnosisName +
                "\nSymptoms: " + symptoms +
                "\nSeverity: " + severity +
                "\nNotes: " + (notes.isBlank() ? "None" : notes);
    }
}

