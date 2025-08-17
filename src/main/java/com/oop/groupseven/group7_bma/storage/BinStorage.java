package com.oop.groupseven.group7_bma.storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinStorage {
    private static final String FILE_NAME = "inspections.bin";

    public static void saveRecord(InspectionRecord record) {
        List<InspectionRecord> all = readAll();
        all.add(record);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(all);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<InspectionRecord> readAll() {
        File f = new File(FILE_NAME);
        if (!f.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                return (List<InspectionRecord>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
