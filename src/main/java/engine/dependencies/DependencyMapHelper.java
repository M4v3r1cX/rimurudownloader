package engine.dependencies;

import java.util.HashMap;

public class DependencyMapHelper {
    // Podría haber hecho esto mejor? Sí. Lo voy a hacer mejor? No.
    private HashMap<DependencyDownloader.DEPENDENCY, String> WIN;
    private HashMap<DependencyDownloader.DEPENDENCY, String> LIN;
    private HashMap<DependencyDownloader.DEPENDENCY, String> MAC;

    public DependencyMapHelper(){
        loadMaps();
    }

    private void loadMaps() {
        this.WIN = new HashMap<>();
        WIN.put(DependencyDownloader.DEPENDENCY.YT_DLP, "https://github.com/yt-dlp/yt-dlp/releases/latest/download/yt-dlp.exe");
        WIN.put(DependencyDownloader.DEPENDENCY.FFMPEG, "https://evermeet.cx/ffmpeg/ffmpeg-122005-g52c84b06d5.zip");

        this.LIN = new HashMap<>();
        LIN.put(DependencyDownloader.DEPENDENCY.YT_DLP, "https://github.com/yt-dlp/yt-dlp/releases/latest/download/yt-dlp_linux");
        LIN.put(DependencyDownloader.DEPENDENCY.FFMPEG, "https://github.com/BtbN/FFmpeg-Builds/releases/download/latest/ffmpeg-master-latest-linux64-gpl.tar.xz");

        this.MAC = new HashMap<>();
        MAC.put(DependencyDownloader.DEPENDENCY.YT_DLP, "https://github.com/yt-dlp/yt-dlp/releases/latest/download/yt-dlp_macos");
        MAC.put(DependencyDownloader.DEPENDENCY.FFMPEG, "https://evermeet.cx/ffmpeg/ffmpeg-122005-g52c84b06d5.zip");
    }

    public String getURL(OSDetector.OS currentOS, DependencyDownloader.DEPENDENCY dependency) {
        String ret = "";

        switch (currentOS) {
            case WIN -> {
                ret = WIN.get(dependency);
            }
            case MAC -> {
                ret = MAC.get(dependency);
            }
            case LIN -> {
                ret = LIN.get(dependency);
            }
        }

        return ret;
    }
}
