package com.ucarinc.Filter;

import com.ucarinc.serviceImpl.GuestbookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "GuestbookCreateFilter")
public class GuestbookCreateFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();
        // 获取当前用户名
        String userName = (String)session.getAttribute("user");
        System.out.println("CreateFilter-user: "+userName);
        // 获取该用户的所有留言
        try{
            GuestbookServiceImpl helper = new GuestbookServiceImpl();
            session.setAttribute("Guestbook", helper.getUserGuestbooks(userName));
//            for (Bean.Guestbook book:helper.getUserGuestbooks(userName)) {
//                System.out.println(book);
//            }
        }catch (Exception e){
            e.printStackTrace();
        }


        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
