package clientServerDemo

import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket
import java.util.Scanner

class Client {
    fun start() {
        val socket = Socket("localhost", 8080)
        socket.use {
            val inpStream = DataInputStream(socket.getInputStream())
            val outputStream = DataOutputStream(socket.getOutputStream())
            val scanner = Scanner(System.`in`)
            while (scanner.hasNextLine()) {
                outputStream.writeUTF(scanner.nextLine())
                println("Сервер сказал: ${inpStream.readUTF()}")
            }

        }
    }

}