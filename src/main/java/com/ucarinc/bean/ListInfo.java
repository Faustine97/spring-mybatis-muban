package com.ucarinc.bean;

public class ListInfo {
    private String user_name;
    private int start;
    private int count;

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String userName) {
        this.user_name = userName;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ListInfo() {
    }

    public ListInfo(int start, int count) {
        this.start = start;
        this.count = count;
    }

    public ListInfo(String userName, int start, int count) {
        this.user_name = userName;
        this.start = start;
        this.count = count;
    }
}
