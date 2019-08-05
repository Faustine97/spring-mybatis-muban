package com.ucarinc.serviceImpl;

import com.ucarinc.bean.UserInfo;
import com.ucarinc.dao.UserInfoDao;
import com.ucarinc.daoImpl.UserInfoDaoImpl;
import com.ucarinc.service.UserInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao userInfoDao;
    public UserInfoServiceImpl()
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        userInfoDao = ac.getBean("userInfoDaoImpl" ,UserInfoDaoImpl.class);
    }
    public List<UserInfo> getAllUserInfo()
    {
        return userInfoDao.getAllUserInfo();
    }
}
