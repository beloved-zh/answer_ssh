package com.zh.model;

import javax.persistence.*;

@Entity
@Table(name = "t_statistics", schema = "answer", catalog = "")
public class TStatisticsEntity {
    private int tid;
    private String allTopic;
    private String correctAnswer;
    private String errorAnswer;
    private Integer fraction;
    private String uid;
    private String startTime;
    private String endTime;
    private Integer answerNumber;
    private String subject;
    private String allAnswer;
    private String returnJson;
    private String myAnswer;

    @Id
    @Column(name = "tid")
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "allTopic")
    public String getAllTopic() {
        return allTopic;
    }

    public void setAllTopic(String allTopic) {
        this.allTopic = allTopic;
    }

    @Basic
    @Column(name = "correctAnswer")
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Basic
    @Column(name = "errorAnswer")
    public String getErrorAnswer() {
        return errorAnswer;
    }

    public void setErrorAnswer(String errorAnswer) {
        this.errorAnswer = errorAnswer;
    }

    @Basic
    @Column(name = "fraction")
    public Integer getFraction() {
        return fraction;
    }

    public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }

    @Basic
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "startTime")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endTime")
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "answerNumber")
    public Integer getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(Integer answerNumber) {
        this.answerNumber = answerNumber;
    }

    @Basic
    @Column(name = "Subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "allAnswer")
    public String getAllAnswer() {
        return allAnswer;
    }

    public void setAllAnswer(String allAnswer) {
        this.allAnswer = allAnswer;
    }

    @Basic
    @Column(name = "returnJson")
    public String getReturnJson() {
        return returnJson;
    }

    public void setReturnJson(String returnJson) {
        this.returnJson = returnJson;
    }

    @Basic
    @Column(name = "MyAnswer")
    public String getMyAnswer() {
        return myAnswer;
    }

    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }

    @Override
    public String toString() {
        return "TStatisticsEntity{" +
                "tid=" + tid +
                ", allTopic='" + allTopic + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", errorAnswer='" + errorAnswer + '\'' +
                ", fraction=" + fraction +
                ", uid='" + uid + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", answerNumber=" + answerNumber +
                ", subject='" + subject + '\'' +
                ", allAnswer='" + allAnswer + '\'' +
                ", returnJson='" + returnJson + '\'' +
                ", myAnswer='" + myAnswer + '\'' +
                '}';
    }
}
