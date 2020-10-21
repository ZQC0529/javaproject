package com.occamedu.servlet;

import cn.hutool.json.JSONUtil;
import com.occamedu.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ysw
 * @email 1461182123@qq.com
 * @date 2020/10/17 3:38 下午
 * @description
 */
@WebServlet("/hello")
public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        String name = request.getParameter("name");
//        String url = request.getParameter("url");
//        System.out.println(name);
//        System.out.println(url);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");// 注意設置為utf-8否則前端接收到的中文為亂碼
        PrintWriter out = response.getWriter();
        User user = new User();
        user.setAge(18);
        user.setName("ysw");
//        ArrayList<Test1Object> arraylistTest = new ArrayList<Test1Object>();
//
//        Test1Object t1 = new Test1Object();
//        Test1Object t2 = new Test1Object();
//
//        t1.setName(name);
//        t1.setUrl(url);
//        t2.setName(name);
//        t2.setUrl(url);
//
//        arraylistTest.add(t1);
//        arraylistTest.add(t2);
//
//        String info = gson.toJson(arraylistTest);
//        // 打印出檢查
//        System.out.println(JSONUtil.toJsonStr(user)
//        );
        // 返回給前端
        out.write(JSONUtil.toJsonStr(user));

    }
}
