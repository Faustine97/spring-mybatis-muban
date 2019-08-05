package com.ucarinc.daoImpl;

import com.ucarinc.bean.User;
import com.ucarinc.dao.UserDao;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.context.ApplicationContext;

public class UserDaoImpl implements UserDao {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int getUserId(String userName)
    {
        Integer id = sqlSession.selectOne("getUserId",userName);
        if(id!=null)
            return id;
        else
            return -1;
    }
    public User getUser(String userName)
    {
        return sqlSession.selectOne("getUser", userName);
    }
    public boolean updateUser(User user)
    {
        if(sqlSession.update("updateUser",user)<=0){
            return false;
        }
        else{
            return true;
        }
    }
}
