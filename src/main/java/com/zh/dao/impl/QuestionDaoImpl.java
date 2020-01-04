package com.zh.dao.impl;

import com.zh.dao.QuestionDao;
import com.zh.model.TQuestionEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class QuestionDaoImpl extends HibernateDaoSupport implements QuestionDao {

    // 注入会话工厂对象
    @Resource
    public void setSF(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<TQuestionEntity> findByNumberAndCourseNO(Integer[] courseNO, int number) {

        Session session = this.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        String hql = "from TQuestionEntity where questionSub in (:courseNO) order by Rand()";

        List<TQuestionEntity> list = session.createQuery(hql).setParameterList("courseNO", courseNO).setMaxResults(number).list();

        transaction.commit();
        session.close();

        return list;
    }

    @Override
    public List<TQuestionEntity> findByIds(Integer[] ids) {

        Session session = this.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        String hql = "from TQuestionEntity where questionId in (:ids)";

        List<TQuestionEntity> list = session.createQuery(hql).setParameterList("ids", ids).list();

        transaction.commit();
        session.close();

        return list;
    }
}
