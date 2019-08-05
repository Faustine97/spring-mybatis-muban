package com.ucarinc.daoImpl;

import com.ucarinc.bean.UserInfo;
import com.ucarinc.dao.UserInfoDao;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserInfoDaoImpl implements UserInfoDao {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<UserInfo> getAllUserInfo()
    {
        return sqlSession.selectList("getAllUserInfo");
    }
}
