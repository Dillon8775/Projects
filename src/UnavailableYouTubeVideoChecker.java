import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UnavailableYouTubeVideoChecker {
    private static int i = 0;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<String> videoIds = readVideoIdsFromFile("C:\\Users\\dillo\\OneDrive\\Miscellaneous\\YouTube Unavailable Video Fixer\\video_ids.txt");

        for (String videoId : videoIds) {
            checkVideo(videoId);
            i++;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("\nFinished reading " + (i-1) + " videos in " + ((endTime - startTime) / 1000) + " seconds.");
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

            if (content.contains("Video unavailable") || content.contains("video is not available") || content.contains("404 Not Found")) {
                System.out.println("<!>");
                System.out.println(urlStr+videoId + " is UNAVAILABLE.");
                System.out.println("<!>");
            } else {
                System.out.println(videoId + " is good...");
            }
        } catch (Exception e) {
            System.out.println(videoId + " => ERROR: " + e.getMessage());
        }
    }
}