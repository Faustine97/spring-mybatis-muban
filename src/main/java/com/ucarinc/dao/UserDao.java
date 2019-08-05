package com.ucarinc.dao;

import com.ucarinc.bean.User;

public interface UserDao {
    public int getUserId(String userName);
    public User getUser(String userName);
    public boolean updateUser(User user);

}
