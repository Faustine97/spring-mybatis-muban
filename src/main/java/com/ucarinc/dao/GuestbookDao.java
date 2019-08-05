package com.ucarinc.dao;

import com.ucarinc.bean.Guestbook;

import java.util.List;

public interface GuestbookDao {
    public boolean addGuestbook(Guestbook book);
    public boolean deleteGuestbook(Guestbook book);
    public boolean updateGuestbook(Guestbook book);
    public List<Guestbook> getAllGuestbooks(int start, int count);
    public List<Guestbook> getAllGuestbooks();
    public List<Guestbook> getUserGuestbooks(String userName);
    public List<Guestbook> getUserGuestbooks(String userName, int start, int count);
    public int getUserGuestbooksCount(String userName);
    public int getAllGuestbooksCount();

}
