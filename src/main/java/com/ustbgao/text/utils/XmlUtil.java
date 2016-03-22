package com.ustbgao.text.utils;

import com.ustbgao.text.bean.ResourceItemBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * read resources xml file util tools
 * Created by ustbgao on 15-8-26.
 */
public class XmlUtil {
    public static List<ResourceItemBean> readXml(String xmlFilePath){
        SAXReader reader = new SAXReader();
        File file = new File(xmlFilePath);
        if(!file.exists()){
            System.out.println("the xml file isn't exists");
        }
        Document document = null;
        try {
            document = reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        List resourceItems = root.elements("resourceitem");
        Iterator iterator = resourceItems.iterator();
        List<ResourceItemBean> resourceItemBeans = new ArrayList<ResourceItemBean>();
        while(iterator.hasNext()){
            Element element = (Element)iterator.next();
            ResourceItemBean resourceItemBean = new ResourceItemBean();
            resourceItemBean.setId(Integer.parseInt(element.element("id").getTextTrim()));
            resourceItemBean.setTitle(element.element("title").getTextTrim());
            resourceItemBean.setAuthor(element.element("author").getTextTrim());
            resourceItemBean.setDate(element.element("date").getTextTrim());
            resourceItemBean.setDescribe(element.element("describe").getTextTrim());
            resourceItemBean.setKeywords(element.element("keywords").getTextTrim());
//            resourceItemBean.setPublisher(element.element("publisher").getTextTrim());
            resourceItemBean.setKind(element.element("kind").getTextTrim());
            resourceItemBean.setUrl(element.element("url").getTextTrim());
            resourceItemBeans.add(resourceItemBean);
        }
        return resourceItemBeans;
    }
    public static void main(String [] args){
        XmlUtil.readXml("e:/test.xml");
    }
}
