package com.ustbgao.text.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ustbgao on 16-2-9.
 */
public class Server {
    public static void main(String []  args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(9999);
        while(true){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(socket.getInetAddress());
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String temp = null;
            while((temp = bufferedReader.readLine()) != null){
                System.out.println("客户端发送出来的信息是:" + temp);
                if(temp.equals("hello server")){
                    break;
                }
            }

        }
    }
}
