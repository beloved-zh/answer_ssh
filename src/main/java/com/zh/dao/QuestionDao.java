package com.zh.dao;

import com.zh.model.TQuestionEntity;

import java.util.List;

public interface QuestionDao {

    List<TQuestionEntity> findByNumberAndCourseNO(Integer[] courseNO,int number);

    List<TQuestionEntity> findByIds(Integer[] ids);
}
