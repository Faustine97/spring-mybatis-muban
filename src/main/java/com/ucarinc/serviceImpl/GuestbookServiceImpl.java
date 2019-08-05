package com.ucarinc.serviceImpl;

import com.ucarinc.bean.Guestbook;
import com.ucarinc.dao.GuestbookDao;
import com.ucarinc.daoImpl.GuestbookDaoImpl;
import com.ucarinc.service.GuestbookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class GuestbookServiceImpl implements GuestbookService {
    private GuestbookDao guestbookDaoImpl;
    public GuestbookServiceImpl()
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        guestbookDaoImpl = ac.getBean("guestbookDaoImpl", GuestbookDaoImpl.class);
    }
    public boolean addGuestbook(Guestbook book){
        return guestbookDaoImpl.addGuestbook(book);
    }
    public boolean deleteGuestbook(Guestbook book){
        return guestbookDaoImpl.deleteGuestbook(book);
    }
    public boolean updateGuestbook(Guestbook book){
        return guestbookDaoImpl.updateGuestbook(book);
    }
    public List<Guestbook> getAllGuestbooks(int start, int count){
        return guestbookDaoImpl.getAllGuestbooks(start,count);
    }
    public List<Guestbook> getAllGuestbooks(){
        return guestbookDaoImpl.getAllGuestbooks();
    }
    public List<Guestbook> getUserGuestbooks(String userName){
        return guestbookDaoImpl.getUserGuestbooks(userName);
    }
    public List<Guestbook> getUserGuestbooks(String userName, int start, int count){
        return guestbookDaoImpl.getUserGuestbooks(userName, start, count);
    }
    public int getUserGuestbooksCount(String userName){
        return guestbookDaoImpl.getUserGuestbooksCount(userName);
    }
    public int getAllGuestbooksCount(){
        return guestbookDaoImpl.getAllGuestbooksCount();
    }
}
