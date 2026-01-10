package engine.dependencies;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class DependencyDownloader {
    public enum DEPENDENCY {
        YT_DLP, FFMPEG
    }

    private OSDetector osDetector;
    private DependencyMapHelper dependencyMapHelper;

    public DependencyDownloader() {
        this.osDetector = new OSDetector();
        this.dependencyMapHelper = new DependencyMapHelper();
    }

    public void checkDependencies() throws Exception {
        // if dependency doesnt exists
        downloadDependencies();
    }

    public boolean downloadDependencies() throws Exception{
        boolean ret = false;
        System.out.println("Downloading Dependencies...");
        System.out.println("Detected OS: " + osDetector.getCurrentOS().name());
        String urlYtdlp = dependencyMapHelper.getURL(osDetector.getCurrentOS(), DEPENDENCY.YT_DLP);
        System.out.println("Downloading YT-DLP...");
        downloadFile(urlYtdlp, "ytdlp" + (osDetector.getCurrentOS().equals(OSDetector.OS.WIN) ? ".exe" : ""));
        System.out.println("YT-DLP download completed.");

        return ret;
    }

    private void downloadFile(String url, String filename) throws Exception{
        InputStream in = new URL(url).openStream();
        ReadableByteChannel readableByteChannel = Channels.newChannel(in);
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        FileChannel fileChannel = fileOutputStream.getChannel();
        fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
    }
}
