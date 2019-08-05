package com.ucarinc.Filter;


import com.ucarinc.serviceImpl.GuestbookServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "GuestbookListFilter")
public class GuestbookListFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();

        String style ;
        if(session.getAttribute("style")==null)
        {
            style = request.getParameter("style");
        }
        else
        {
            if(!"".equals(request.getParameter("style")))
                style = request.getParameter("style");
            else
                style = (String)session.getAttribute("style");
        }
        // 从session中的allPagePos属性获取当前页数，第一次进来是null，需要对allPagePos赋值
        // 从session中的onePagePos属性获取当前页数，第一次进来是null，需要对onePagePos赋值
        if(null == session.getAttribute("pagePos"))
        {
            session.setAttribute("pagePos",0);
        }
        if(null == session.getAttribute("allPagePos"))
        {
            session.setAttribute("allPagePos",0);
        }
        if(null == session.getAttribute("onePagePos"))
        {
            session.setAttribute("onePagePos",0);
        }
        // 获取guestbook对象，存入session中的Guestbooks对象中
        // 获取request中的style变量，若是null：第一次进入则显示all，若是all：则显示全部
        GuestbookServiceImpl helper = new GuestbookServiceImpl();
        int count = 10;
        if(null==style || "".equals(style) || "all".equals(style))
        {
            int pos = (Integer)session.getAttribute("allPagePos");
            session.setAttribute("Guestbooks", helper.getAllGuestbooks(pos*count,count));
            session.setAttribute("message_list_style", "all");
        }
        else
        {
            int pos = (Integer)session.getAttribute("onePagePos");
            String user_name = (String)session.getAttribute("user");
            session.setAttribute("Guestbooks", helper.getUserGuestbooks(user_name,pos*count,count));
            session.setAttribute("message_list_style_user_name", user_name);
            session.setAttribute("message_list_style", "one");
        }
        chain.doFilter(req, resp);
    }
    public void init(FilterConfig config) throws ServletException {

    }

}
