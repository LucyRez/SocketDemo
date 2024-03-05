package httpDemo

import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.ServerSocket

class Server {
    fun run() {
        val serverSocket = ServerSocket(8080)
        val socket = serverSocket.accept()

        val inpStream = DataInputStream(socket.getInputStream())
        val outStream = DataOutputStream(socket.getOutputStream())

        //println(inpStream.readNBytes(10000))


        val str = "Good job!"

        val header = """
            HTTP/1.1 200 OK
            content-type: text/plain
            content-length: %s
        """.trimIndent().format(str.toByteArray().size)
        outStream.write(header.toByteArray())
        outStream.write(str.toByteArray())
    }
}