package com.ustbgao.text.utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ustbgao on 15-8-26.
 */
public class FileServer {
    public static void main(String [] args){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9999);
            while(true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                FileWriter fileWriter = new FileWriter("e:/upload/upload.txt", true);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp = null;
                while((temp = bufferedReader.readLine()) != null){
                    fileWriter.write(temp + "\n");

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
