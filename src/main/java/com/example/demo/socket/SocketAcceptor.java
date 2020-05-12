package com.example.demo.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Boris
 * @date 2020/5/12 17:02
 */
public class SocketAcceptor {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(9999)) {

            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader.readLine());

            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("收到\n");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
