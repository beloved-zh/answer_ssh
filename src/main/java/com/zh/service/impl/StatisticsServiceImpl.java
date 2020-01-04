package com.zh.service.impl;

import com.zh.dao.StatisticsDao;
import com.zh.model.TStatisticsEntity;
import com.zh.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsDao dao;

    @Override
    public int add(TStatisticsEntity statistics) {
        return dao.add(statistics);
    }

    @Override
    public List<TStatisticsEntity> fingByUid(String uid) {
        return dao.fingByUid(uid);
    }

    @Override
    public List<TStatisticsEntity> findAll() {
        return dao.findAll();
    }
}
