package com.zh.model;

import javax.persistence.*;

@Entity
@Table(name = "t_course", schema = "answer")
public class TCourseEntity {
    private int courseNo;
    private String courseName;
    private Integer marks;

    @Id
    @Column(name = "courseNO")
    public int getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(int courseNo) {
        this.courseNo = courseNo;
    }

    @Basic
    @Column(name = "courseName")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "marks")
    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "TCourseEntity{" +
                "courseNo=" + courseNo +
                ", courseName='" + courseName + '\'' +
                ", marks=" + marks +
                '}';
    }
}
