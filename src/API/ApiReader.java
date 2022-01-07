package API;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiReader implements DataReader{
    private final String url;
    private HttpResponse<String> response;

    public ApiReader(String url) {
        this.url = url;
    }

    @Override
    public String read() throws IOException {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(this.url)).build();
        HttpClient client = HttpClient.newBuilder().build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String[] words = objectMapper.readValue(response.body().toString(), String[].class);

        return words[(int) (Math.random() * words.length)];
    }
}
