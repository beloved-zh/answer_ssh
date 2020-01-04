package com.zh.model;

import javax.persistence.*;

@Entity
@Table(name = "userbase", schema = "answer", catalog = "")
public class UserbaseEntity {
    private String userId;
    private String userName;
    private String passWord;
    private String userNo;
    private Integer userClass;
    private String classroomId;
    private String tel;
    private Integer isLock;
    private String bak;
    private Integer isDel;

    @Id
    @Column(name = "UserID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "UserName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "PassWord")
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Basic
    @Column(name = "UserNo")
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    @Basic
    @Column(name = "UserClass")
    public Integer getUserClass() {
        return userClass;
    }

    public void setUserClass(Integer userClass) {
        this.userClass = userClass;
    }

    @Basic
    @Column(name = "ClassroomID")
    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    @Basic
    @Column(name = "Tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "IsLock")
    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    @Basic
    @Column(name = "BAK")
    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak;
    }

    @Basic
    @Column(name = "IsDel")
    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "UserbaseEntity{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userNo='" + userNo + '\'' +
                ", userClass=" + userClass +
                ", classroomId='" + classroomId + '\'' +
                ", tel='" + tel + '\'' +
                ", isLock=" + isLock +
                ", bak='" + bak + '\'' +
                ", isDel=" + isDel +
                '}';
    }
}
