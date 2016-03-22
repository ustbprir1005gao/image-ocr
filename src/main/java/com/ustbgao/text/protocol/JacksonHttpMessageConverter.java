package com.ustbgao.text.protocol;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by ustbgao on 15-8-26.
 */
public class JacksonHttpMessageConverter extends MappingJackson2HttpMessageConverter {
    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (obj instanceof JSONPObject) {
            JSONPObject jsonp = (JSONPObject) obj;
            OutputStream out = outputMessage.getBody();
            String text = jsonp.getFunction() + "(" + JSON.toJSONString(jsonp.getJson()) + ")";
            byte[] bytes = text.getBytes(DEFAULT_CHARSET);
            out.write(bytes);
        } else {
            super.writeInternal(obj, outputMessage);
        }
    }
}
