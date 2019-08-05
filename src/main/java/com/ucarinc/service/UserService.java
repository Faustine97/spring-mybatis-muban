package com.ucarinc.service;

import com.ucarinc.bean.User;

public interface UserService {
    public int getUserId(String userName);
    public User getUser(String userName);
    public boolean updateUser(User user);
}
