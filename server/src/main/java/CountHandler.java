import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class CountHandler implements HttpHandler {
    int counter = 0;
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        counter++;
        String response = "На путь /count обратились:" + counter + "раз(а)";
        exchange.sendResponseHeaders(200, response.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
        System.out.println(response);
    }
}