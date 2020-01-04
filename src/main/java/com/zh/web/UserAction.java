package com.zh.web;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.zh.model.UserbaseEntity;
import com.zh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.swing.*;

@Controller
@Scope("prototype")
public class UserAction implements Action, ModelDriven<UserbaseEntity> {

    @Autowired
    private UserService userService;
    private UserbaseEntity user = new UserbaseEntity();
    private String b;

    public String login(){

        System.out.println("进入login"+user);

        user = userService.login(user);

        if (user != null){
            ActionContext.getContext().getSession().put("user",user);

            b = "true";
        }else {
            b = "false";
        }
        return "login";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserbaseEntity getUser() {
        return user;
    }

    public void setUser(UserbaseEntity user) {
        this.user = user;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String execute() throws Exception {
        return null;
    }

    @Override
    public UserbaseEntity getModel() {
        return user;
    }
}
