package com.zh.dao.impl;

import com.zh.dao.UserDao;
import com.zh.model.UserbaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    // 注入会话工厂对象
    @Resource
    public void setSF(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }


    @Override
    public UserbaseEntity login(UserbaseEntity user) {
        String hql = "from UserbaseEntity where userNo = ? and passWord = ?";

        SessionFactory sessionFactory = this.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery(hql).setParameter(0, user.getUserNo()).setParameter(1, user.getPassWord());

        UserbaseEntity userbaseEntity = (UserbaseEntity) query.uniqueResult();

        transaction.commit();
        session.close();

        return userbaseEntity;
    }
}
