package com.oop.groupseven.group7_bma.Zainab;

public class TreatmentDetails {
    private String medicineName;
    private String dosage;
    private String therapyDietInstructions;

    public TreatmentDetails(String medicineName, String dosage, String therapyDietInstructions) {
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.therapyDietInstructions = therapyDietInstructions;
    }

    public String getMedicineName() { return medicineName; }
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }

    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }

    public String getTherapyDietInstructions() { return therapyDietInstructions; }
    public void setTherapyDietInstructions(String therapyDietInstructions) { this.therapyDietInstructions = therapyDietInstructions; }

    @Override
    public String toString() {
        return "Medicine: " + medicineName +
                "\nDosage: " + dosage +
                "\nTherapy/Diet: " + (therapyDietInstructions.isBlank() ? "None" : therapyDietInstructions);
    }
}
