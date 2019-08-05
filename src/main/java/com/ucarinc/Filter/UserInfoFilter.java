package com.ucarinc.Filter;

import com.ucarinc.bean.UserInfo;
import com.ucarinc.serviceImpl.GuestbookServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import com.ucarinc.serviceImpl.UserInfoServiceImpl;
import com.ucarinc.serviceImpl.UserServiceImpl;
@WebFilter(filterName = "UserInfoFilter")
public class UserInfoFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        UserInfoServiceImpl helper = new UserInfoServiceImpl();
        List<UserInfo> list = helper.getAllUserInfo();
        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();
        session.setAttribute("UserInfo", list);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
