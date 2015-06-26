package com.wzy.bean;

/**
 * Created by Y_Y DE YI on 2015/6/26.
 */
public class SelectInfo {
    private String record_time;
    private String course_name;
    private String attendance_status;

    public SelectInfo() {
        super();
    }

    public SelectInfo(String record_time, String course_name, String attendance_status) {
        this.record_time = record_time;
        this.course_name = course_name;
        this.attendance_status = attendance_status;
    }

    public String getRecord_time() {
        return record_time;
    }

    public void setRecord_time(String record_time) {
        this.record_time = record_time;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getAttendance_status() {
        return attendance_status;
    }

    public void setAttendance_status(String attendance_status) {
        this.attendance_status = attendance_status;
    }
}
