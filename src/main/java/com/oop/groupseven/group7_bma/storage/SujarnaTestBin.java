package com.oop.groupseven.group7_bma.storage;

import java.time.LocalDate;

public class SujarnaTestBin {
    public static void main(String[] args) {
        SujarnaBinStorage.saveRecord(new SujarnaInspectionRecord(
                LocalDate.now(), "Corporate Camp", "OK", "Setup complete"
        ));
        System.out.println("Total: " + SujarnaBinStorage.readAll().size());
        SujarnaBinStorage.readAll().forEach(System.out::println);
    }
}
