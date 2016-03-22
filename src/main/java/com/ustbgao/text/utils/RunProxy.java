package com.ustbgao.text.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by ustbgao on 16-2-11.
 */
public class RunProxy {
    public static void main(String [] args){
        LookUpServiceImpl lookUpService = new LookUpServiceImpl();
        LookUpInvocationHandle lookUpInvocationHandle = new LookUpInvocationHandle();
        lookUpInvocationHandle.setTarget(lookUpService);
        LookUpService real = (LookUpService) Proxy.newProxyInstance(lookUpInvocationHandle.getTarget().getClass().getClassLoader(),
                lookUpInvocationHandle.getTarget().getClass().getInterfaces(),
                lookUpInvocationHandle);
        real.lookUpMethod("hello");
    }
}
