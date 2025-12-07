package engine.dependencies;

public class OSDetector {
    public enum OS {
        WIN("Windows"), MAC("MacOS"), LIN("Linux");

        OS(String name) {}
    }

    private OS currentOS;

    public OSDetector() {
        String os = System.getProperty("os.name");
        if (os.contains("Mac")) {
            currentOS = OS.MAC;
        } else if (os.contains("Windows")) {
            currentOS = OS.WIN;
        } else {
            currentOS = OS.LIN;
        }
    }

    public OS getCurrentOS() {
        return this.currentOS;
    }
}
