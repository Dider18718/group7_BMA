package com.oop.groupseven.group7_bma.storage;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public record InspectionRecord(
        LocalDate date,
        String owner,
        String category,
        String status,
        String notes
) implements Serializable {
    @Serial private static final long serialVersionUID = 1L;

    public static InspectionRecord ofWard(
            LocalDate date, String owner, String roomId,
            String oxygenStatus, String bedStatus, String ventilatorStatus,
            String notes
    ) {
        String combined = String.format("O2=%s | Bed=%s | Vent=%s",
                val(oxygenStatus), val(bedStatus), val(ventilatorStatus));
        return new InspectionRecord(date, owner, roomId, combined, notes == null ? "" : notes);
    }
    private static String val(String s){ return (s==null || s.isBlank()) ? "N/A" : s.trim(); }
}
