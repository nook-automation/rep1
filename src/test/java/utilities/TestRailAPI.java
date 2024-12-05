package utilities;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;


import java.io.File;
import java.io.IOException;

public class TestRailAPI {

    private static final String TESTRAIL_URL = "https://nook.testrail.com/index.php?/runs/view/91648&group_by=cases:section_id&group_order=asc";
    private static final String API_KEY = "G76ePR6uxA4xETkqmZu.-i1TIFkK/1sUinlnsd4OZ";
    private static final String USERNAME = "Kvengattan@bn.com";

    public static void uploadScreenshot(String screenshotPath, String resultId) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(TESTRAIL_URL.replace("<result_id>", resultId));
            post.addHeader("Authorization", "Basic " + encodeCredentials(USERNAME, API_KEY));

            // Build the multipart form entity to send the file
            File screenshotFile = new File(screenshotPath);
            HttpEntity entity = MultipartEntityBuilder.create()
                    .addBinaryBody("attachment", screenshotFile)
                    .build();
            post.setEntity(entity);

            HttpResponse response = client.execute(post);
            // Handle the response (e.g., check for success or failure)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String encodeCredentials(String username, String apiKey) {
        String auth = username + ":" + apiKey;
        return java.util.Base64.getEncoder().encodeToString(auth.getBytes());
    }
}

