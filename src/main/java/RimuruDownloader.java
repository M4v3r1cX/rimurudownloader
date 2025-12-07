import engine.dependencies.DependencyDownloader;

public class RimuruDownloader {

    public static void main(String[] args) {
        try {
            printHeader();
            downloadDependencies();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.exit(0);
    }

    private static void downloadDependencies() throws Exception{
        DependencyDownloader dependencyDownloader = new DependencyDownloader();
        dependencyDownloader.downloadDependencies();
    }

    private static void printHeader() {
        System.out.println("Rimuru Downloader =");
        System.out.println("===================");
    }
}
