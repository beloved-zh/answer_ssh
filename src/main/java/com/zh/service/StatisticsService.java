package com.zh.service;

import com.zh.model.TStatisticsEntity;

import java.util.List;

public interface StatisticsService {

    int add(TStatisticsEntity statistics);

    List<TStatisticsEntity> fingByUid(String uid);

    List<TStatisticsEntity> findAll();
}
