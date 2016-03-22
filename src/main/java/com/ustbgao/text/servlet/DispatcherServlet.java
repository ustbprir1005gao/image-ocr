package com.ustbgao.text.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ustbgao on 15-8-26.
 */
public class DispatcherServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("success");
        System.out.println(req.getQueryString());
        System.out.println(req.getAuthType());
        req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req , resp);
    }
}
