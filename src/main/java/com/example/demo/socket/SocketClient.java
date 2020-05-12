package com.example.demo.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Boris
 * @date 2020/5/12 17:02
 */
public class SocketClient {

    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 9999)) {
            socket.setSoTimeout(5000);
            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("给你一个message，请收好\n");
            writer.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
