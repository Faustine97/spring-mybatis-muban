package com.ucarinc.bean;

public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private String user_email;
    private String user_telephone;
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_telephone() {
        return user_telephone;
    }

    public void setUser_telephone(String user_telephone) {
        this.user_telephone = user_telephone;
    }
    public  User(){}
    public User(int user_id, String user_name, String user_password, String user_email, String user_telephone) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_email = user_email;
        this.user_telephone = user_telephone;
    }

    public User(int user_id, String user_name, String user_email, String user_telephone) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_telephone = user_telephone;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_telephone='" + user_telephone + '\'' +
                '}';
    }
}