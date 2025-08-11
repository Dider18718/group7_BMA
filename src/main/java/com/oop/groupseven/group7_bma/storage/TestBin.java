import com.oop.groupseven.group7_bma.storage.BinStorage;
import com.oop.groupseven.group7_bma.storage.InspectionRecord;

import java.time.LocalDate;
import java.util.List;

public class TestBin {
    public static void main(String[] args) {
        // ✅ Create record with all 6 arguments
        InspectionRecord rec = new InspectionRecord(
                LocalDate.now(),         // date
                "Room-101",              // roomId
                "Working",               // oxygen status
                "Available",             // bed status
                "OK",                    // ventilator status
                "Everything looks fine"  // notes
        );

        // ✅ Save it
        BinStorage.saveRecord(rec);
        System.out.println("✅ Saved record to inspections.bin");

        // ✅ Read back
        List<InspectionRecord> records = BinStorage.readAll();
        System.out.println("📂 Records in file:");
        for (InspectionRecord r : records) {
            System.out.println(r);
        }
    }
}

