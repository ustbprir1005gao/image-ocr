package com.ustbgao.text.utils;

import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * Created by ustbgao on 16-2-11.
 */
public class ExecutorServer {

    class ServerService{
        private String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
    private static final int THREADSNUM = 100;
    private static final Executor exec = Executors.newFixedThreadPool(THREADSNUM);

    /**
     * 处理客户端请求
     *
     * @param socket
     */
    public static void handleRequest(Socket socket) throws IOException{

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String temp = null;
        try {
            Class<?> c = Class.forName("ServerService");
            try {
                Object o = c.newInstance();
                ((ServerService)o).setMsg("hello");
                System.out.println("test");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        while((temp = bufferedReader.readLine()) != null){
            System.out.println("客户端请求发送来的参数为:" + temp);
            if(temp.equals("hello")){

                break;

            }
        }
    }

    public static void main(String [] args){
        try {
            final ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("服务器现在正在处理来自客户端的请求:....");
            System.out.println(serverSocket.getReceiveBufferSize());
            System.out.println(Runtime.getRuntime().availableProcessors());

            while(true){
                final Socket connection = serverSocket.accept();
                Runnable task = new Runnable(){
                    public void run(){
                        try {
                            ExecutorServer.handleRequest(connection);
                            System.out.println(serverSocket.getReceiveBufferSize());

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                exec.execute(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
