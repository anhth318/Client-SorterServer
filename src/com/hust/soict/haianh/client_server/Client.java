package com.hust.soict.haianh.client_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9898);

        // Streams for conversing with server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Consume and display welcome message from the server
        System.out.println(in.readLine());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter some numbers separated by space character to send to the Server (empty to quit):");
            String message = scanner.nextLine();
            if (message == null || message.isEmpty()) {
                break;
            }
            out.println(message);
            System.out.println("Received sorted numbers from Server: " + in.readLine());
        }
        socket.close();
        scanner.close();
    }
}
