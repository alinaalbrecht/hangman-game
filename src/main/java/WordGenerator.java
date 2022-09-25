import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WordGenerator {
    public String getWord () {
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://random-words5.p.rapidapi.com/getRandom"))
                    .header("X-RapidAPI-Key", System.getenv("RANDOM_WORD_API_KEY"))
                    .header("X-RapidAPI-Host", "random-words5.p.rapidapi.com")
                    .GET()
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (URISyntaxException e) {
            System.out.println("URISyntaxException");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        return null;
    }
}
