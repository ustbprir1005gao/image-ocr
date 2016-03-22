package com.ustbgao.text.serviceimpl;

import com.ustbgao.text.api.service.ResourceService;
import com.ustbgao.text.bean.ResourceItemBean;
import com.ustbgao.text.utils.XmlUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ustbgao on 15-8-26.
 */
@Service
public class ResourceServiceImple implements ResourceService {
    @Override
    public List<ResourceItemBean> getResourceItems() {
        List<ResourceItemBean> resourceItemBeans = XmlUtil.readXml("e:/test.xml");
        return resourceItemBeans;
    }
}
