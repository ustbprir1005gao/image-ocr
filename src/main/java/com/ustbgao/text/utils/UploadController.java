package com.ustbgao.text.utils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ustbgao on 15-8-26.
 */
@Controller
public class UploadController {
    @RequestMapping(value = "/upload.do")
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {

        MultipartRequest multipartRequest = null;
        System.out.println("开始上传文件");
        System.out.println(request.getSession().getServletContext().getRealPath(""));
        String path = request.getSession().getServletContext().getRealPath("index.jsp");
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
//      String fileName = new Date().getTime()+".jpg";
        File targetFile = new File("e:/upload", fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Runtime runTime = Runtime.getRuntime();
        String filePath = "e:/upload/" + fileName;
        String cmd = "tesseract " + filePath + " " + " " +"e:/result4";
        try {
            runTime.exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File file1 = new File("e:/result4.txt");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String temp = null;
        String result = "";
        try{
            fileReader = new FileReader(file1);
            bufferedReader = new BufferedReader(fileReader);
        while((temp = bufferedReader.readLine()) != null){
            result += temp;
        }
        }catch(IOException e){
            e.printStackTrace();

        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);
        model.addAttribute("result" , result);
        return "result";
    }
}
