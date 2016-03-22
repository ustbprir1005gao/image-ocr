package com.ustbgao.text.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by ustbgao on 16-2-11.
 */
public class LookUpInvocationHandle implements InvocationHandler {
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        method.invoke(target, args);
        return null;
    }
}
