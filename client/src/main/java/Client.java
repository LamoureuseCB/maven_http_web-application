import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("http://localhost:8080/count");
        HttpRequest request = HttpRequest.newBuilder().
                GET()
                .uri(uri)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Обращение к эндпоинту /count ");
        System.out.println("Статус: " + response.statusCode());
        System.out.println("Ответ: " + response.body());
    }
}

