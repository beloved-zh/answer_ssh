package com.zh.web;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.zh.model.TCourseEntity;
import com.zh.service.TCourseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class TCourseEntityAction implements Action, ModelDriven<TCourseEntity> {

    @Autowired
    private TCourseEntityService ser;
    private TCourseEntity tCourseEntity = new TCourseEntity();
    private List<TCourseEntity> list;

    public String findAll(){
        System.out.println("进入findAll");

        list = ser.findAll();
        System.out.println(list);
        return "findAll";
    }


    @Override
    public String execute() throws Exception {
        return null;
    }

    public TCourseEntityService getSer() {
        return ser;
    }

    public void setSer(TCourseEntityService ser) {
        this.ser = ser;
    }

    public TCourseEntity gettCourseEntity() {
        return tCourseEntity;
    }

    public void settCourseEntity(TCourseEntity tCourseEntity) {
        this.tCourseEntity = tCourseEntity;
    }

    public List<TCourseEntity> getList() {
        return list;
    }

    public void setList(List<TCourseEntity> list) {
        this.list = list;
    }

    @Override
    public TCourseEntity getModel() {
        return tCourseEntity;
    }
}
