package com.ucarinc.Filter;

import com.ucarinc.bean.JdbcHelper;
import com.ucarinc.bean.User;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginCheckFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        System.out.println(0);
        HttpServletRequest request = (HttpServletRequest)req;
//        System.out.println(0.1);
        HttpServletResponse response = (HttpServletResponse)resp;
//        System.out.println(0.2);
        HttpSession session = request.getSession();
        try{
//            System.out.println(1);
            Connection conn = JdbcHelper.getConnection();
//            System.out.println(2);
            String user = req.getParameter("user");
//            System.out.println(3);
            String password = req.getParameter("password");
//            System.out.println(4);
//            System.out.println("user: "+ user);
//            System.out.println("password: " + password);
            String sql = "select * from `user` where user_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            ResultSet rs = ps.executeQuery();
            // 如果查找不到该用户
            if(rs.next()==false)
            {

            }
            // 如果查找到用户，则比较密码
            else
            {
                String result = rs.getString("user_password");
//                System.out.println("user_password: "+ result);
                // 密码正确
                if(result.equals(password))
                {
                    String user_name = rs.getString("user_name");
                    int user_id = rs.getInt("user_id");
                    String user_email = rs.getString("user_email");
                    String user_telephone = rs.getString("user_telephone");

                    User user_edit = new User(user_id, user_name, user_email, user_telephone);

                    session.setAttribute("user",user);
                    session.setAttribute("user_edit", user_edit);
                    String context = request.getContextPath();
                    response.sendRedirect(context + "/message_list.jsp");
                }
                // 密码错误
                else{

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
