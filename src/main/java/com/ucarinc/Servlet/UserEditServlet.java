package com.ucarinc.Servlet;

import com.ucarinc.bean.User;
import com.ucarinc.serviceImpl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(name = "UserEditServlet")
public class UserEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImpl helper = new UserServiceImpl();
        HttpSession session = request.getSession();
        User user_edit = (User)session.getAttribute("user_edit");

        String user_name = request.getParameter("user_name");
        String user_password = request.getParameter("user_password");
        String user_email = request.getParameter("user_email");
        String user_telephone = request.getParameter("user_telephone");

        user_edit.setUser_email(user_email);
        user_edit.setUser_name(user_name);
        user_edit.setUser_password(user_password);
        user_edit.setUser_telephone(user_telephone);
        session.setAttribute("user_edit", user_edit);

        helper.updateUser(user_edit);
        String context = request.getContextPath();
        String page = "/"+"user_edit.jsp";
        response.sendRedirect(context+page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
