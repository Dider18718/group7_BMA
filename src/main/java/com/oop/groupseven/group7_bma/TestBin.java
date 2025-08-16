package com.oop.groupseven.group7_bma;

import com.oop.groupseven.group7_bma.storage.BinStorage;
import com.oop.groupseven.group7_bma.storage.InspectionRecord;

import java.time.LocalDate;
import java.util.List;

public class TestBin {
    public static void main(String[] args) {
        // BinStorage.clear();

        BinStorage.saveRecord(new InspectionRecord(LocalDate.now(),"Sujarna","Corporate Camp","OK","Setup complete"));
        BinStorage.saveRecord(new InspectionRecord(LocalDate.now(),"Zainab","Pharmacy Stock","Low","Order antibiotics"));
        BinStorage.saveRecord(new InspectionRecord(LocalDate.now(),"Shibli","Patient Intake","OK","Queue smooth"));
        BinStorage.saveRecord(new InspectionRecord(LocalDate.now(),"Dider","Admin Audit","OK","Shift roster updated"));

        List<InspectionRecord> all = BinStorage.readAll();
        System.out.println("All records = " + all.size());
        all.forEach(System.out::println);
    }
}
