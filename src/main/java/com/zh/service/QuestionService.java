package com.zh.service;

import com.zh.model.TQuestionEntity;

import java.util.List;

public interface QuestionService {

    List<TQuestionEntity> findByNumberAndCourseNO(Integer[] courseNO, int number);

    List<TQuestionEntity> findByIds(String ids);

}
