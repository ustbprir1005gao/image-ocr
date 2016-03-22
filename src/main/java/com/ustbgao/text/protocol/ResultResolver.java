package com.ustbgao.text.protocol;



/**
 * 暂无描述
 * Author: gaoqi
 * Date: 2015-03-25 10:56
 */
public class ResultResolver {

    public static ViewResultModel sendNormalResult(Object data){
        ViewResultModel viewResultModel = new ViewResultModel();
        viewResultModel.setData(data);
        return viewResultModel;
    }
}

