package com.ucarinc.Servlet;

import com.ucarinc.bean.Guestbook;
import com.ucarinc.bean.User;
import com.ucarinc.serviceImpl.GuestbookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

//@WebServlet(name = "GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        System.out.println("Servlet");
        String btnStyle = request.getParameter("btnStyle");
//        System.out.println("2");
        // 获取被按下message_id
        String messageId = request.getParameter("messageId");
//        System.out.println("messageId: "+messageId);
        int message_id = Integer.parseInt(messageId);
        String message_title = request.getParameter("messageTitle");
        String message_content = request.getParameter("messageContent");
        Timestamp message_edit_time = new Timestamp(System.currentTimeMillis());
//        System.out.println("3");
        Guestbook book = new Guestbook();
        book.setMessage_title(message_title);
        book.setMessage_content(message_content);
        book.setMessage_id(message_id);
        book.setMessage_edit_time(message_edit_time);
//        System.out.println("4");
        GuestbookServiceImpl helper = new GuestbookServiceImpl();
        if("update".equals(btnStyle))
        {
//            System.out.println("update");
            helper.updateGuestbook(book);
        }
        else if("delete".equals(btnStyle))
        {
//            System.out.println("delete");
            helper.deleteGuestbook(book);
        }
//        System.out.println("6");
        String context = request.getContextPath();
        String page ="/"+request.getParameter("website");
        response.sendRedirect(context + page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request, response);
//        String text1 = request.getParameter("text1");
//        System.out.println("doGet-text1: "+text1);
//
//        String style = request.getParameter("style");
//        System.out.println("doGet-style: "+style);
        doPost(request,response);

    }
}
