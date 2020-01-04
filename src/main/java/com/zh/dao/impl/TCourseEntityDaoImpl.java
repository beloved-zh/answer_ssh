package com.zh.dao.impl;

import com.zh.dao.TCourseEntityDao;
import com.zh.model.TCourseEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class TCourseEntityDaoImpl extends HibernateDaoSupport implements TCourseEntityDao {

    // 注入会话工厂对象
    @Resource
    public void setSF(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<TCourseEntity> findAll() {

        String hql = "from TCourseEntity";

        List<TCourseEntity> list = (List<TCourseEntity>) this.getHibernateTemplate().find(hql);

        return list;
    }
}
