package com.ustbgao.text.protocol;

/**
 * Created by ustbgao on 15-8-26.
 */
public class JSONPObject {
    private String function;//JSONP回调方法
    private Object json;//真正的Json对象

    public JSONPObject(String function, Object json) {
        this.function = function;
        this.json = json;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Object getJson() {
        return json;
    }

    public void setJson(Object json) {
        this.json = json;
    }
}
