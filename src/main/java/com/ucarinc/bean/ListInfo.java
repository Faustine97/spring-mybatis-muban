package com.ucarinc.bean;

public class ListInfo {
    private String user_name;
    private int start;
    private int count;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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
