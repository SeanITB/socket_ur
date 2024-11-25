package org.example

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {
    val port = 5858
    // Obrir el servidor
    val serverSocket = ServerSocket(port)
    println("Attempting to start socket server...")

    // Obrir la porta a clients
    val clientSocket = serverSocket.accept()
    val output = PrintWriter(clientSocket.getOutputStream(), true)

    // Llegir el que diu el robot
    val input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
    val actualPose: String = input.readLine()
    println("This is my actual pose :$actualPose")


    // actual pose to final pose
    output.println("(0.222887,0.141989,0.24792,1.23286,-1.20128,-1.22264)")

    //Tancar el server
    serverSocket.close()
}



fun stringToMutableList(inputLine: String): MutableList<Double> {
    val subInput = inputLine.subSequence(2, inputLine.length -1 )
    return subInput.split(",").map{ it.toDouble() }.toMutableList()
}