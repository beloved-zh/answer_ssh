package com.zh.model;

import javax.persistence.*;

@Entity
@Table(name = "t_question", schema = "answer", catalog = "")
public class TQuestionEntity {
    private int questionId;
    private String questionText;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String questionAnswer;
    private int questionSub;

    @Id
    @Column(name = "question_id")
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "question_text")
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @Basic
    @Column(name = "answer_a")
    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    @Basic
    @Column(name = "answer_b")
    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    @Basic
    @Column(name = "answer_c")
    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    @Basic
    @Column(name = "answer_d")
    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    @Basic
    @Column(name = "question_answer")
    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    @Basic
    @Column(name = "question_sub")
    public int getQuestionSub() {
        return questionSub;
    }

    public void setQuestionSub(int questionSub) {
        this.questionSub = questionSub;
    }

    @Override
    public String toString() {
        return "TQuestionEntity{" +
                "questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                ", answerD='" + answerD + '\'' +
                ", questionAnswer='" + questionAnswer + '\'' +
                ", questionSub=" + questionSub +
                '}';
    }
}
