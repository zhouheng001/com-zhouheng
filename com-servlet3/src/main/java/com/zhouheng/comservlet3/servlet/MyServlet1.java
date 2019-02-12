package com.zhouheng.comservlet3.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-31 12:02
 */
@WebServlet(value = "/servlet3.0")
public class MyServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("测试servlet3.0");
    }
}
