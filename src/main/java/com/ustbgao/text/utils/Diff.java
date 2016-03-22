package com.ustbgao.text.utils;

/**
 * Created by ustbgao on 16-2-27.
 */
public class Diff {
    public static void main(String [] args){
        int a = 1999;
        int b = 2299;
        int c = (a^b);
        System.out.println(c);
        int num=0;
        while(c != 0){
            if((c&1) != 0){
                num++;
            }
            c=c>>1;
        }
        System.out.println(num);
    }
}
