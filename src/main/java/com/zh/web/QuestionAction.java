package com.zh.web;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.zh.model.TQuestionEntity;
import com.zh.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.persistence.Convert;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class QuestionAction implements Action, ModelDriven<TQuestionEntity> {

    @Autowired
    private QuestionService ser;
    private TQuestionEntity question = new TQuestionEntity();
    private Integer[] courseNO;
    private int number;
    private List<TQuestionEntity> list;
    private String ids;

    public String findByIds(){
        System.out.println("进入findByIds");
        System.out.println(ids);

        list = ser.findByIds(ids);

        return "userRecord";
    }

    public String findByNumberAndCourseNO(){

        System.out.println("进入查题");
        list = ser.findByNumberAndCourseNO(courseNO,number);
        return "findByNumberAndCourseNO";
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public QuestionService getSer() {
        return ser;
    }

    public void setSer(QuestionService ser) {
        this.ser = ser;
    }

    public TQuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(TQuestionEntity question) {
        this.question = question;
    }

    public Integer[] getCourseNO() {
        return courseNO;
    }

    public void setCourseNO(Integer[] courseNO) {
        this.courseNO = courseNO;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<TQuestionEntity> getList() {
        return list;
    }

    public void setList(List<TQuestionEntity> list) {
        this.list = list;
    }

    @Override
    public String execute() throws Exception {
        return null;
    }

    @Override
    public TQuestionEntity getModel() {
        return null;
    }
}
