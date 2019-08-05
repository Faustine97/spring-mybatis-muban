package com.ucarinc.Servlet;



import com.ucarinc.serviceImpl.GuestbookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(name = "PagingServlet")
public class PagingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String style = request.getParameter("style");
        String message_list_style = (String)session.getAttribute("message_list_style");
        if("pre".equals(style))
        {
            if("all".equals(message_list_style))
            {
                int pos = (Integer)session.getAttribute("allPagePos");
                if(pos>0)
                {
                    pos--;
                    session.setAttribute("allPagePos",pos);
                }
            }
            else if("one".equals(message_list_style))
            {
                int pos = (Integer)session.getAttribute("onePagePos");
                if(pos>0)
                {
                    pos--;
                    session.setAttribute("onePagePos",pos);
                }
            }

        }
        else if("next".equals(style))
        {
            if("all".equals(message_list_style))
            {
                int pos = (Integer)session.getAttribute("allPagePos");
                int count = (new GuestbookServiceImpl()).getAllGuestbooksCount();
                if((pos+1)*10 < count)
                {
                    pos++;
                    session.setAttribute("allPagePos", pos);
                }
            }
            else if("one".equals(message_list_style))
            {
                int pos = (Integer)session.getAttribute("onePagePos");
                String user_name = (String)session.getAttribute("message_list_style_user_name");
                int count = (new GuestbookServiceImpl()).getUserGuestbooksCount(user_name);
                if((pos+1)*10 < count) {
                    pos++;
                    session.setAttribute("onePagePos",pos);
                }
            }
        }
        String context = request.getContextPath();
        response.sendRedirect(context + "/message_list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
