package com.ustbgao.text.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.SocketHandler;

/**
 * Created by ustbgao on 16-2-16.
 */
public class NIOServerSocket {

    public static void service(){
        while(true){
            SocketChannel socketChannel = null;


        }
    }
    public static  void main(String [] args) throws IOException{
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().setReuseAddress(true);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while(selector.select() > 0){

            Set readKeys = selector.selectedKeys();
            Iterator it = readKeys.iterator();
            SelectionKey key = null;
            while(it.hasNext()){

                 key = (SelectionKey)it.next();
                it.remove();
                if(key.isAcceptable()){
                    ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                    SocketChannel socketChannel = (SocketChannel)ssc.accept();
                    System.out.println(socketChannel.socket().getInetAddress()+":" + socketChannel.socket().getPort());
                    System.out.println("处理连接就绪事件");
                }
                if(key.isReadable()){
                    System.out.println("处理读就绪时间");
                }
                if(key.isWritable()){
                    System.out.println("处理写就绪时间");
                }
            }
            if(key != null){
                key.cancel();
                key.channel().close();
            }
        }

    }
}
