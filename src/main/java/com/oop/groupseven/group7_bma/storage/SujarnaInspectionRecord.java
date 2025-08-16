package com.oop.groupseven.group7_bma.storage;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public record SujarnaInspectionRecord(
        LocalDate date,
        String category,
        String status,
        String notes
) implements Serializable {
    @Serial private static final long serialVersionUID = 1L;
}
