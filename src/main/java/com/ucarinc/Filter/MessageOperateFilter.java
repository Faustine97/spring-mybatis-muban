package com.ucarinc.Filter;


import com.ucarinc.bean.Guestbook;
import com.ucarinc.serviceImpl.GuestbookServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;

@WebFilter(filterName = "MessageOperateFilter")
public class MessageOperateFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        System.out.println("1");
        String btnStyle = request.getParameter("btnStyle");
        System.out.println("btnStyle: "+btnStyle);
        if(btnStyle!=null)
        {
            String messageId = request.getParameter("messageId");
            System.out.println("messageId"+messageId);
            int message_id = Integer.parseInt(messageId);
            String message_title = request.getParameter("messageTitle");
            String message_content = request.getParameter("messageContent");
            Timestamp message_edit_time = new Timestamp(System.currentTimeMillis());
            System.out.println("3");
            Guestbook book = new Guestbook();
            book.setMessage_title(message_title);
            book.setMessage_content(message_content);
            book.setMessage_id(message_id);
            book.setMessage_edit_time(message_edit_time);
            System.out.println("4");
            GuestbookServiceImpl helper = new GuestbookServiceImpl();
            if("update".equals(btnStyle))
            {
                System.out.println("update");
                helper.updateGuestbook(book);
            }
            else if("delete".equals(btnStyle))
            {
                System.out.println("delete");
                helper.deleteGuestbook(book);
            }
            System.out.println("6");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
