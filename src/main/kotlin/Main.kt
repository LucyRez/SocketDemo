import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.IOException
import java.net.Socket
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration

// Socket Example
//fun main(args: Array<String>) {
//    val socket = Socket("hse.ru", 80)
//    try {
//        socket.use {
//            val outputStream = DataOutputStream(socket.getOutputStream())
//            val inputStream = DataInputStream(socket.getInputStream())
//            outputStream.writeUTF("Hello HSE!")
//            val response = inputStream.readAllBytes()
//            println(response.joinToString( "") { it.toInt().toChar().toString()})
//        }
//
//    } catch (e: IOException) {
//        socket.close()
//    }
//
//}


// HTTP Example
fun main(args: Array<String>) {


    val httpClient = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)
        .build()

    val request = HttpRequest.newBuilder(
        URI.create("https://cs.hse.ru"))
        .GET().build()

    val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
    println(response.body())

}