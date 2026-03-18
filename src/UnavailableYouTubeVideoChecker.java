import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UnavailableYouTubeVideoChecker {
    private static final List<String> videoIdsPC = readVideoIdsFromFile("E:\\OneDrive\\Miscellaneous\\YouTube Unavailable Video Fixer\\video_ids.txt");
    private static int i = 0;
    private static int unavailableVideos = 0;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        for (String videoId : videoIdsPC) {
            checkVideo(videoId);
            i++;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("\nFinished reading " + (i) + " videos in " + ((endTime - startTime) / 1000) + " seconds.");
        if (unavailableVideos != 0) {
            System.out.println(unavailableVideos + " video(s) were found unavailable.");
        }
    }

    private static List<String> readVideoIdsFromFile(String filePath) {
        List<String> videoIds = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    videoIds.add(line.trim());
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return videoIds;
    }

    private static void checkVideo(String videoId) {
        try {
            String urlStr = "https://www.youtube.com/watch?v=" + videoId;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setInstanceFollowRedirects(true);
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                System.out.println(videoId + " => ERROR: HTTP " + responseCode);
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder pageContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                pageContent.append(line);
            }
            reader.close();

            String content = pageContent.toString();

            if (content.contains("Video unavailable") ||
                    content.contains("video is not available") ||
                    content.contains("404 Not Found") ||
                    content.contains("Private video")) {
                System.out.println("<!> #" + (i+1) + ": " + urlStr+videoId + " is UNAVAILABLE.");
                unavailableVideos++;
            } else {
                System.out.println("#" + (i+1) + "/" + videoIdsPC.toArray().length + ": " + videoId + " is good...");
            }
        } catch (Exception e) {
            System.out.println(videoId + " => ERROR: " + e.getMessage());
        }
    }
}