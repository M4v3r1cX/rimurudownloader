package engine.db;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/* El nombre es por usar algo entendible, pero va a ser un archivo en texto plano con la extension .db dfjksdf */
public class DatabaseManager {
    private File db;
    private ArrayList<String> songsInDb = new ArrayList<>();

    public DatabaseManager() throws IOException {
        String dbPath = Paths.get("").toAbsolutePath().toString() + File.separator + "rimuru.db";
        db = new File(dbPath);
        if (!db.exists()) {
            db.createNewFile();
        }
        loadDb();
    }

    private void loadDb() throws IOException{
        try (Stream<String> stream = Files.lines(db.toPath())) {
            stream.forEach(line -> {
                songsInDb.add(line);
            });
        } catch (IOException e) {
            throw e;
        }
    }

    public boolean songExistsInDb(String id) {
        return songsInDb.contains(id);
    }

    public void addSongToDb(String id) {
        songsInDb.add(id);
    }

    public void deleteSongFromDb(String id) {
        songsInDb.remove(id);
    }

    public void writeDbToDisk() throws IOException {
        String dbPath = Paths.get("").toAbsolutePath().toString() + File.separator + "rimuru.db.temp";
        File tempDb = new File(dbPath);
        Files.write(tempDb.toPath(), songsInDb);

        if (db.delete()) {
            tempDb.renameTo(db);
        }
    }
}
