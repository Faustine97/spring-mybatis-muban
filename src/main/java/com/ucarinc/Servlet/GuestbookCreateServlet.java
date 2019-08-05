package com.ucarinc.Servlet;

import com.ucarinc.bean.Guestbook;
import com.ucarinc.bean.User;
import com.ucarinc.serviceImpl.UserServiceImpl;
import com.ucarinc.serviceImpl.GuestbookServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

//@WebServlet(name = "GuestbookCreateServlet")
public class GuestbookCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        System.out.println(1);
        String userName  = (String)session.getAttribute("user");
        // 构建Guestbook对象
        System.out.println(2);
        UserServiceImpl helper = new UserServiceImpl();
        String message_title = request.getParameter("message_title");
        String message_content = request.getParameter("message_content");
        Timestamp message_create_time = new Timestamp(System.currentTimeMillis());
        Timestamp message_edit_time = new Timestamp(System.currentTimeMillis());
        int user_id = helper.getUserId(userName);
        System.out.println(3);
        Guestbook book = new Guestbook();
        book.setMessage_title(message_title);
        book.setMessage_content(message_content);
        book.setMessage_create_time(message_create_time);
        book.setMessage_edit_time(message_edit_time);
        book.setUser_id(user_id);
        System.out.println(4);
        GuestbookServiceImpl impl = new GuestbookServiceImpl();
        // 使用jdbchelper添加
        impl.addGuestbook(book);
        System.out.println(5);
        // 返回
        String context = request.getContextPath();

        String page = "/" + (String)request.getParameter("website");
        System.out.println("website:" + context + page);
        response.sendRedirect(context + page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
