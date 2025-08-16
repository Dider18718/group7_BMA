package com.oop.groupseven.group7_bma.Zainab;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MedicineResult {
    private final StringProperty resultText;

    public MedicineResult(String resultText) {
        this.resultText = new SimpleStringProperty(resultText);
    }

    public String getResultText() { return resultText.get(); }
    public void setResultText(String value) { resultText.set(value); }
    public StringProperty resultTextProperty() { return resultText; }
}
