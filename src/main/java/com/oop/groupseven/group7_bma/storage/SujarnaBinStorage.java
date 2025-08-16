package com.oop.groupseven.group7_bma.storage;

import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SujarnaBinStorage {
    private static final Logger LOG = Logger.getLogger(SujarnaBinStorage.class.getName());
    private static final Path FILE = Paths.get(System.getProperty("user.home"), ".bma", "sujarna_inspections.bin");

    private SujarnaBinStorage() {}

    public static void clear() {
        try { Files.deleteIfExists(FILE); } catch (IOException e) { LOG.log(Level.WARNING, "clear", e); }
    }

    public static void saveRecord(SujarnaInspectionRecord rec) {
        List<SujarnaInspectionRecord> all = readAll();
        all.add(rec);
        ensureDir();
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(FILE))) {
            oos.writeObject(all);
        } catch (IOException e) { LOG.log(Level.SEVERE, "write", e); }
    }

    @SuppressWarnings("unchecked")
    public static List<SujarnaInspectionRecord> readAll() {
        if (!Files.exists(FILE)) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(FILE))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?> list) return (List<SujarnaInspectionRecord>) list;
        } catch (InvalidClassException ice) { clear(); }
        catch (IOException | ClassNotFoundException e) { LOG.log(Level.SEVERE, "read", e); }
        return new ArrayList<>();
    }

    private static void ensureDir() {
        try { Files.createDirectories(FILE.getParent()); } catch (IOException e) { LOG.log(Level.WARNING, "mkdirs", e); }
    }
}
