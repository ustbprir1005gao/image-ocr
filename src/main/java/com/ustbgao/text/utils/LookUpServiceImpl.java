package com.ustbgao.text.utils;

/**
 * Created by ustbgao on 16-2-11.
 */
public class LookUpServiceImpl implements LookUpService {

    @Override
    public void lookUpMethod(String methodName) {

        Client.lookUpMethod(methodName);
    }
}
