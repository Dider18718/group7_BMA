package com.oop.groupseven.group7_bma.Zainab;

public class DiagnosticTestRecommendation {
    private String testName;
    private String urgencyLevel;
    private String notes;

    public DiagnosticTestRecommendation(String testName, String urgencyLevel, String notes) {
        this.testName = testName;
        this.urgencyLevel = urgencyLevel;
        this.notes = notes;
    }

    public String getTestName() { return testName; }
    public void setTestName(String testName) { this.testName = testName; }

    public String getUrgencyLevel() { return urgencyLevel; }
    public void setUrgencyLevel(String urgencyLevel) { this.urgencyLevel = urgencyLevel; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public String toString() {
        return "Test: " + testName +
                "\nUrgency: " + urgencyLevel +
                "\nNotes: " + (notes.isBlank() ? "None" : notes);
    }
}
