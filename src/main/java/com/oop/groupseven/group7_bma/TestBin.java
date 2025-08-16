package com.oop.groupseven.group7_bma.storage;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

public class TestBin {
    public static void main(String[] args) {
        // Optional: start clean
        // new File("inspections.bin").delete();

        BinStorage.saveRecord(new InspectionRecord(
                "INS-" + System.currentTimeMillis(),
                "Sujarna",
                LocalDateTime.now(),
                "All safety checks passed.",
                5
        ));

        BinStorage.saveRecord(new InspectionRecord(
                "INS-" + (System.currentTimeMillis() + 1),
                "Sujarna",
                LocalDateTime.now().minusMinutes(10),
                "Minor dent on rear door.",
                3
        ));

        List<InspectionRecord> all = BinStorage.readAll();
        System.out.println("Total records: " + all.size());
        for (InspectionRecord r : all) System.out.println(r);

        File f = new File("inspections.bin");
        System.out.println("File exists? " + f.exists() + " | size=" + (f.exists()? f.length() : 0) + " bytes");
    }
}
