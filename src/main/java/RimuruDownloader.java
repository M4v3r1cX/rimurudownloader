import engine.db.DatabaseManager;
import engine.dependencies.DependencyDownloader;

public class RimuruDownloader {

    private static DatabaseManager databaseManager;

    public static void main(String[] args) {
        try {
            printHeader();
            initDb();
            downloadDependencies();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.exit(0);
    }

    private static void initDb() throws Exception{
        databaseManager = new DatabaseManager();
    }

    private static void downloadDependencies() throws Exception{
        DependencyDownloader dependencyDownloader = new DependencyDownloader();
        dependencyDownloader.checkDependencies();
    }

    private static void printHeader() {
        System.out.println("Rimuru Downloader =");
        System.out.println("===================");
    }
}
