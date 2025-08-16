package com.oop.groupseven.group7_bma.storage.Zainab;

import com.oop.groupseven.group7_bma.storage.InspectionRecord;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ZainabStorage {package com.oop.groupseven.group7_bma.storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

    public class BinStorage {
        // choose where to keep the file (safe & writable):
        private static final String FILE_PATH = System.getProperty("user.home") + File.separator + "inspections.bin";

        public static void saveRecord(InspectionRecord record) {
            List<InspectionRecord> all = readAll();
            all.add(record);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                oos.writeObject(all);
                System.out.println("Saved 1 record -> " + FILE_PATH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @SuppressWarnings("unchecked")
        public static List<InspectionRecord> readAll() {
            File f = new File(FILE_PATH);
            if (!f.exists()) return new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                Object obj = ois.readObject();
                if (obj instanceof List<?>) {
                    return (List<InspectionRecord>) obj;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        }
    }
