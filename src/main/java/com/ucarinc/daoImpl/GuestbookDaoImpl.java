package com.ucarinc.daoImpl;

import com.ucarinc.bean.Guestbook;
import com.ucarinc.bean.ListInfo;
import com.ucarinc.dao.GuestbookDao;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class GuestbookDaoImpl implements GuestbookDao {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public boolean addGuestbook(Guestbook book) {
        try {
            sqlSession.insert("addGuestbook", book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteGuestbook(Guestbook book) {
        try {
            sqlSession.update("deleteGuestbook", book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateGuestbook(Guestbook book){

        try{
            sqlSession.update("updateGuestbook",book);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public List<Guestbook> getAllGuestbooks(int start, int count){
        ListInfo info = new ListInfo(start, count);
        return sqlSession.selectList("getAllGuestbooks", info);
    }
    public List<Guestbook> getAllGuestbooks(){
        return sqlSession.selectList("getAllGuestbooks2");
    }
    public List<Guestbook> getUserGuestbooks(String userName){
        return sqlSession.selectList("getUserGuestbooks", userName);
    }
    public List<Guestbook> getUserGuestbooks(String userName, int start, int count){
        ListInfo info = new ListInfo(userName, start, count);
        return sqlSession.selectList("getUserGuestbooks2", info);
    }
    public int getUserGuestbooksCount(String userName){
        Integer count = sqlSession.selectOne("getUserGuestbooksCount", userName);
        if(count == null)
            return -1;
        else
            return count;
    }
    public int getAllGuestbooksCount(){
        Integer count = sqlSession.selectOne("getAllGuestbooksCount");
        if(count == null)
            return -1;
        else
            return count;
    }

}
