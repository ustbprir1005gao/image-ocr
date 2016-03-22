package com.ustbgao.text.utils;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by ustbgao on 16-2-3.
 */
public class Client {

    /**
     * 对分布式方法中存在的方法进行查找，此处需要进行代理查找
     *
     * @param methodName
     * @return
     */
    public static Object lookUpMethod(String methodName){

        SocketAddress client = new InetSocketAddress("localhost", 9999);
        Socket socket = new Socket();
        try {
            socket.connect(client, 10000);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
            printWriter.println(methodName);
            printWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main (String [] args) throws IOException{
        SocketAddress client = new InetSocketAddress("localhost", 9999);
        Socket socket = new Socket();
        try {
            socket.connect(client, 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
        printWriter.println("hello server");
        printWriter.flush();
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String temp = null;
        while((temp = bufferedReader.readLine()) != null){

            System.out.println("收到服务器传输的字符串是:" + temp);
        }*/

    }
}
