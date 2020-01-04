package com.zh.web;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.zh.model.TStatisticsEntity;
import com.zh.model.UserbaseEntity;
import com.zh.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class StatisticsAction implements Action, ModelDriven<TStatisticsEntity> {

    @Autowired
    private StatisticsService ser;
    private TStatisticsEntity statistics = new TStatisticsEntity();
    private List<TStatisticsEntity> list;

    public String findByUid(){

        UserbaseEntity user = (UserbaseEntity) ActionContext.getContext().getSession().get("user");

        String uid = user.getUserId();

        list = ser.fingByUid(uid);

        return "userRecord";
    }
    public String findAll(){

        list = ser.findAll();

        return "userRecord";
    }

    public String add(){
        System.out.println("进入add");
        System.out.println(statistics);

        int add = ser.add(statistics);

        return "add";
    }

    public StatisticsService getSer() {
        return ser;
    }

    public void setSer(StatisticsService ser) {
        this.ser = ser;
    }

    public TStatisticsEntity getStatistics() {
        return statistics;
    }

    public void setStatistics(TStatisticsEntity statistics) {
        this.statistics = statistics;
    }

    public List<TStatisticsEntity> getList() {
        return list;
    }

    public void setList(List<TStatisticsEntity> list) {
        this.list = list;
    }

    @Override
    public String execute() throws Exception {
        return null;
    }

    @Override
    public TStatisticsEntity getModel() {
        return statistics;
    }
}
