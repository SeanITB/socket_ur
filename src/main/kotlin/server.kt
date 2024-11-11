package org.example

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import kotlin.concurrent.thread

fun main() {
    val port = 5858
    // Obrir el servidor
    val serverSocket = ServerSocket(port)

    // Obrir la porta a clients
    val clientSocket = serverSocket.accept()

    // Llegir el que diu el robot
    val input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))

    // Contestar
    val output = PrintWriter(clientSocket.getOutputStream(), true)


    var inputLine: String = input.readLine()
    while (inputLine == null) {
        inputLine = input.readLine()
        println(inputLine)
    }
    output.println("Adeu")
}
