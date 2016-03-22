package com.ustbgao.text.controller.vo;

import com.ustbgao.text.bean.ResourceItemBean;

import java.util.List;

/**
 * Created by ustbgao on 15-8-26.
 */
public class ResourceResultVO {
    private List<ResourceItemBean> resourcelist ;

    public List<ResourceItemBean> getResourcelist() {
        return resourcelist;
    }

    public void setResourcelist(List<ResourceItemBean> resourcelist) {
        this.resourcelist = resourcelist;
    }
}
