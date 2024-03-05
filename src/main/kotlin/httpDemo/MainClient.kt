package httpDemo

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.file.Path
import java.time.Duration


fun main() {
   val client = HttpClient.newBuilder()
       .version(HttpClient.Version.HTTP_2)
       .connectTimeout(Duration.ofSeconds(30)).build()

    val request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080"))
        .header("content-type", "text/html")
        .POST(
            HttpRequest.BodyPublishers.ofFile(Path.of("src/main/resources/index.html"))
        ).build()

    val result = client.send(request, HttpResponse.BodyHandlers.ofString())
    println(result)


}