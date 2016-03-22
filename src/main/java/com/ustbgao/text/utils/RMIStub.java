package com.ustbgao.text.utils;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * Created by ustbgao on 15-8-26.
 */
public class RMIStub {
    private Socket socket;
    private SocketAddress socketAddress;
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public RMIStub(String host, int port) throws UnknownHostException, IOException {
        socketAddress = new InetSocketAddress(host , port);
        socket = new Socket();
    }

    public void connect(SocketAddress endpoint, int timeout) throws IOException {
        socket.connect(endpoint , timeout);
    }

    /**
     * 发送调用对象的名称
     * @param url
     */
    public void sendInvokeObjectName(String url){
        try {
            OutputStream outputStream = socket.getOutputStream();
            byte [] urlBytes = url.getBytes("utf-8");
            outputStream.write(urlBytes);
            outputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendInvokeParameter(String ... parameters){
        for(String parameter : parameters){

        }
    }

    public static void fileUpload(String filePath){
        Socket client = new Socket();
        SocketAddress address = new InetSocketAddress("localhost", 9999);
        try {
            client.connect(address, 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(filePath);
        if(!file.exists()){
            System.out.println("文件不存在" + filePath);
        }
        try {
            byte [] bytes = new byte[1024*1024*4];
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                OutputStream outputStream = client.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write("##end##");
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
