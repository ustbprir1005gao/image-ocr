package com.ustbgao.text.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ustbgao on 16-2-20.
 */
public class TestSpringScope {
    public static void main(String [] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Client client = (Client)applicationContext.getBean("testScope");
        Client client1  = (Client)applicationContext.getBean("testScope");
        if(client == client1){
            System.out.println("非单例模式");
        }


    }
}
