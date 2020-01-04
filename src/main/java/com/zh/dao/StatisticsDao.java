package com.zh.dao;

import com.zh.model.TStatisticsEntity;

import java.util.List;

public interface StatisticsDao {

    int add(TStatisticsEntity statistics);

    List<TStatisticsEntity> fingByUid(String uid);

    List<TStatisticsEntity> findAll();
}
