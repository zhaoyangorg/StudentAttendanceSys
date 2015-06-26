package com.wzy.bean;

/**
 * Created by Y_Y DE YI on 2015/6/26.
 */
public class TeacherInfo {
    private String teacher_name;
    private String course_name;
    private String college_name;

    public TeacherInfo() {
        super();
    }

    public TeacherInfo(String teacher_name, String course_name, String college_name) {
        this.teacher_name = teacher_name;
        this.course_name = course_name;
        this.college_name = college_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }
}
