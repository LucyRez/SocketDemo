package clientServerDemo

import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.ServerSocket
import java.net.Socket
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class Server {
    val executorService: ExecutorService = Executors.newFixedThreadPool(10)

    fun run() {
        val socketServer = ServerSocket(8080)

        while (true) {
            socketServer.use {
                val socket = socketServer.accept()
                executorService.submit{
                    processSocket(socket)
                }

            }
        }
    }

    private fun processSocket(socket: Socket) {
        val inpStream = DataInputStream(socket.getInputStream())
        val outStream = DataOutputStream(socket.getOutputStream())

        val scanner = Scanner(System.`in`)
        var message = inpStream.readUTF()
        while (!message.equals("STOP")) {
            println("Клиент сказал: $message")
            outStream.writeUTF(scanner.nextLine())
            message = inpStream.readUTF()
        }

        println("Клиент сказал: ${inpStream.readUTF()}")
        outStream.writeUTF("Сервер приветствует клиента!")
    }

}