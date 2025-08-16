package com.oop.groupseven.group7_bma.storage;

import java.io.Serializable;
import java.time.LocalDate;

public class InspectionRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate date;
    private String roomId;
    private String oxygen;
    private String bed;
    private String ventilator;
    private String notes;

    public InspectionRecord(LocalDate date, String roomId, String oxygen, String bed, String ventilator, String notes) {
        this.date = date;
        this.roomId = roomId;
        this.oxygen = oxygen;
        this.bed = bed;
        this.ventilator = ventilator;
        this.notes = notes;
    }

    // getters (and setters if needed)
    public LocalDate getDate() { return date; }
    public String getRoomId() { return roomId; }
    public String getOxygen() { return oxygen; }
    public String getBed() { return bed; }
    public String getVentilator() { return ventilator; }
    public String getNotes() { return notes; }

    @Override
    public String toString() {
        return date + " | " + roomId + " | Oxy:" + oxygen + " | Bed:" + bed + " | Vent:" + ventilator + " | " + notes;
    }
}
