package com.ustbgao.text.controller;

import com.ustbgao.text.api.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ustbgao on 15-8-26.
 */
@RequestMapping("/test")
@Controller
public class ImageSimController {

    @RequestMapping("/getUser.do")
    public ModelAndView sendUserToJsp(String name){

        List<UserModel> models = new ArrayList<UserModel>();
        for(int i = 0; i < 2; i++){
            UserModel model = new UserModel();
            model.setUserId(1);
            model.setUserName("gaoqi");
            models.add(model);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("getValue");
        modelAndView.addObject("models", models);
        modelAndView.addObject("name", name);
        return modelAndView;
    }
}
