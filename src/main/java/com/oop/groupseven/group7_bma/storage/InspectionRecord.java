package com.oop.groupseven.group7_bma.storage;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public record InspectionRecord(
        LocalDate date,
        String owner,     // Sujarna | Zainab | Shibli | Dider
        String category,  // room/area/etc.
        String status,    // compact summary
        String notes
) implements Serializable {
    @Serial private static final long serialVersionUID = 1L;

    // factory: keep your 6 UI inputs
    public static InspectionRecord ofWard(
            LocalDate date, String owner, String roomId,
            String oxygenStatus, String bedStatus, String ventilatorStatus,
            String notes
    ) {
        String combined = "O2=" + val(oxygenStatus) + " | Bed=" + val(bedStatus) + " | Vent=" + val(ventilatorStatus);
        return new InspectionRecord(date, owner, roomId, combined, notes == null ? "" : notes);
    }
    private static String val(String s){ return (s==null || s.isBlank()) ? "N/A" : s.trim(); }
}
