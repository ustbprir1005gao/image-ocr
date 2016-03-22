package com.ustbgao.text.controller;

import com.ustbgao.text.api.service.ResourceService;
import com.ustbgao.text.bean.ResourceItemBean;
import com.ustbgao.text.controller.vo.ResourceResultVO;
import com.ustbgao.text.protocol.ResultResolver;
import com.ustbgao.text.protocol.ViewResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ustbgao on 15-8-26.
 */
@Controller
@RequestMapping(value = "/v1")
public class QueryResourceController {
    @Autowired
    ResourceService resourceService;
    @ResponseBody
    @RequestMapping(value = "/resource/queryResource")
    public ViewResultModel queryResource(){
        ResourceResultVO resourceResultVO = new ResourceResultVO();
        List<ResourceItemBean> resourceItemBeans = resourceService.getResourceItems();
        resourceResultVO.setResourcelist(resourceItemBeans);
       return ResultResolver.sendNormalResult(resourceResultVO);
    }
}
