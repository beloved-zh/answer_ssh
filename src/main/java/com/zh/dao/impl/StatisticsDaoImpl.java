package com.zh.dao.impl;

import com.zh.dao.StatisticsDao;
import com.zh.model.TStatisticsEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class StatisticsDaoImpl extends HibernateDaoSupport implements StatisticsDao {

    // 注入会话工厂对象
    @Resource
    public void setSF(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public int add(TStatisticsEntity statistics) {
        try {
            //调用我们定义的接口  增加数据
            this.getHibernateTemplate().save(statistics);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return 0;
    }

    @Override
    public List<TStatisticsEntity> fingByUid(String uid) {

        String hql = "from TStatisticsEntity where uid=? order by tid desc";

        List<TStatisticsEntity> list = (List<TStatisticsEntity>) this.getHibernateTemplate().find(hql, uid);

        return list;
    }

    @Override
    public List<TStatisticsEntity> findAll() {
        String hql = "from TStatisticsEntity order by tid desc";

        List<TStatisticsEntity> list = (List<TStatisticsEntity>) this.getHibernateTemplate().find(hql);

        return list;
    }
}
