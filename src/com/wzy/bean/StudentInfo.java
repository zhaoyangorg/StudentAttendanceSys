package com.wzy.bean;

/**
 * Created by Y_Y DE YI on 2015/6/25.
 */
public class StudentInfo {
    private Integer student_id;
    private String college_name;
    private String student_name;
    private String student_login_pwd;
    private String student_college;
    private String student_major;
    private String student_email;

    public StudentInfo() {
        super();
    }

    public StudentInfo(Integer student_id, String college_name, String student_name, String student_login_pwd, String student_college, String student_major, String student_email) {
        this.student_id = student_id;
        this.college_name = college_name;
        this.student_name = student_name;
        this.student_login_pwd = student_login_pwd;
        this.student_college = student_college;
        this.student_major = student_major;
        this.student_email = student_email;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public String getCollege_name() {
        return college_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getStudent_login_pwd() {
        return student_login_pwd;
    }

    public String getStudent_college() {
        return student_college;
    }

    public String getStudent_major() {
        return student_major;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_login_pwd(String student_login_pwd) {
        this.student_login_pwd = student_login_pwd;
    }

    public void setStudent_college(String student_college) {
        this.student_college = student_college;
    }

    public void setStudent_major(String student_major) {
        this.student_major = student_major;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }
}
