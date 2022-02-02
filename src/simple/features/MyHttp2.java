package simple.features;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author xiangzhang
 * @since 2022-01-31 23:17
 */
public class MyHttp2 {
    // 能整个大活, java9, java11
    public static void main(String[] args) throws IOException, InterruptedException {
        final HttpClient httpClient = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder(URI.create("https://cn.bing.com/"))
                .header("name", "jacklove")
                .GET()
                .build();
        final HttpResponse<String> send = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(send.body());
    }
}
