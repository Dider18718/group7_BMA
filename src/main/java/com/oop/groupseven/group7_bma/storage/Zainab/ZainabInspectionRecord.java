package com.oop.groupseven.group7_bma.storage.Zainab;

import java.io.Serializable;
import java.time.LocalDate;

public class ZainabInspectionRecord {package com.oop.groupseven.group7_bma.storage;

import java.io.Serializable;
import java.time.LocalDate;

    public class InspectionRecord implements Serializable {
        private static final long serialVersionUID = 1L;

        private LocalDate date;
        private String roomId;
        private String oxygenLevel;
        private String ventilatorCount;
        private String notes;

        public InspectionRecord(LocalDate date, String roomId, String oxygenLevel, String ventilatorCount, String notes) {
            this.date = date;
            this.roomId = roomId;
            this.oxygenLevel = oxygenLevel;
            this.ventilatorCount = ventilatorCount;
            this.notes = notes;
        }

        public LocalDate getDate() { return date; }
        public String getRoomId() { return roomId; }
        public String getOxygenLevel() { return oxygenLevel; }
        public String getVentilatorCount() { return ventilatorCount; }
        public String getNotes() { return notes; }

        @Override
        public String toString() {
            return date + " | Room:" + roomId + " | O2:" + oxygenLevel +
                    " | Vent:" + ventilatorCount + " | " + notes;
        }
    }

}
