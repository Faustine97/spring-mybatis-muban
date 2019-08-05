package com.ucarinc.serviceImpl;

import com.ucarinc.bean.User;
import com.ucarinc.daoImpl.UserDaoImpl;
import com.ucarinc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ucarinc.dao.UserDao;
public class UserServiceImpl implements UserService {
    private UserDao userDaoImpl;
    public UserServiceImpl(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        userDaoImpl = ac.getBean("userDaoImpl", UserDaoImpl.class);
    }

    public int getUserId(String userName)
    {
        return userDaoImpl.getUserId(userName);
    }
    public User getUser(String userName)
    {
        return userDaoImpl.getUser(userName);
    }
    public boolean updateUser(User user)
    {
        return userDaoImpl.updateUser(user);
    }
}
