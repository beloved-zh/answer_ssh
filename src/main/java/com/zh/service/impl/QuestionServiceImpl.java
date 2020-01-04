package com.zh.service.impl;

import com.zh.dao.QuestionDao;
import com.zh.model.TCourseEntity;
import com.zh.model.TQuestionEntity;
import com.zh.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao dao;

    /**
     * 转义<>方法
     * @param list
     * @return
     */
    public static List<TQuestionEntity> zy(List<TQuestionEntity> list) {
        for (TQuestionEntity q1 : list) {
            /*
             *	转义   <   &#60;
             *		<	&#62;
             */
            q1.setQuestionText(q1.getQuestionText().replaceAll("<", "&#60;"));
            q1.setAnswerA(q1.getAnswerA().replaceAll("<", "&#60;"));
            q1.setAnswerB(q1.getAnswerB().replaceAll("<", "&#60;"));
            q1.setAnswerC(q1.getAnswerC().replaceAll("<", "&#60;"));
            q1.setAnswerD(q1.getAnswerD().replaceAll("<", "&#60;"));

        }
        return list;
    }

    @Override
    public List<TQuestionEntity> findByNumberAndCourseNO(Integer[] courseNO, int number) {
        return zy(dao.findByNumberAndCourseNO(courseNO,number));
    }

    @Override
    public List<TQuestionEntity> findByIds(String ids) {
        String[] s = ids.split(", ");
        Integer[] arr = new Integer[s.length];
        for (int i = 0;i < s.length;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        return zy(dao.findByIds(arr));
    }
}
