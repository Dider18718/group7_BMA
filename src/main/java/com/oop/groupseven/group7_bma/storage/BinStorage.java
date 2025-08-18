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

/** Stores all owners' inspections together at ~/.bma/inspections_all.bin */
public final class BinStorage {
    private static final Logger LOG = Logger.getLogger(BinStorage.class.getName());
    private static final Path FILE = Paths.get(System.getProperty("user.home"), ".bma", "inspections_all.bin");

    private BinStorage(){}

    public static synchronized void clear() {
        try { Files.deleteIfExists(FILE); LOG.info(() -> "Cleared: " + FILE); }
        catch (IOException e) { LOG.log(Level.WARNING, "clear failed", e); }
    }

    public static synchronized void saveRecord(InspectionRecord rec) {
        List<InspectionRecord> all = readAll();
        all.add(rec);
        ensureDir();
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(FILE))) {
            oos.writeObject(all);
            LOG.log(Level.INFO, "Saved {0} total record(s) → {1}", new Object[]{all.size(), FILE});
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "write failed", e);
        }
    }

    @SuppressWarnings("unchecked")
    public static synchronized List<InspectionRecord> readAll() {
        if (!Files.exists(FILE)) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(FILE))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?> list) return (List<InspectionRecord>) list;
            LOG.warning(() -> "Unexpected content: " + obj.getClass());
        } catch (InvalidClassException ice) {
            LOG.log(Level.WARNING, "Incompatible file format; resetting.", ice);
            clear();
        } catch (IOException | ClassNotFoundException e) {
            LOG.log(Level.SEVERE, "read failed", e);
        }
        return new ArrayList<>();
    }

    public static synchronized List<InspectionRecord> readByOwner(String owner) {
        List<InspectionRecord> result = new ArrayList<>();
        for (InspectionRecord r : readAll()) {
            if (r.owner() != null && r.owner().equalsIgnoreCase(owner)) result.add(r);
        }
        return result;
    }

    private static void ensureDir() {
        try { Files.createDirectories(FILE.getParent()); }
        catch (IOException e) { LOG.log(Level.WARNING, "mkdirs failed: " + FILE.getParent(), e); }
    }
}
