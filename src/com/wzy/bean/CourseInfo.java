package com.wzy.bean;

/**
 * Created by Y_Y DE YI on 2015/6/26.
 */
public class CourseInfo {
    private String course_name;
    private String class_time;
    private String teacher_name;
    private String class_end_week;

    public CourseInfo() {
        super();
    }

    public CourseInfo(String course_name, String class_time, String teacher_name, String class_end_week) {
        this.course_name = course_name;
        this.class_time = class_time;
        this.teacher_name = teacher_name;
        this.class_end_week = class_end_week;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getClass_end_week() {
        return class_end_week;
    }

    public void setClass_end_week(String class_end_week) {
        this.class_end_week = class_end_week;
    }
}
