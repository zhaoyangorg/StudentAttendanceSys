package com.wzy.model;

import com.wzy.bean.CourseInfo;
import com.wzy.bean.SelectInfo;
import com.wzy.bean.StudentInfo;
import com.wzy.bean.TeacherInfo;

import java.util.List;

/**
 * Created by Y_Y DE YI on 2015/6/25.
 */
public interface StudentDao {
    public boolean studentLogin(Integer student_id,String student_login_pwd);
    public List<SelectInfo> couseIdSelect(Integer stuId,Integer courseId);
    public List<StudentInfo> personInfo(Integer stuId);
    public void updatePwd(Integer stuId,String newPwd);
    public List<TeacherInfo> teacherInfo(Integer stuId);
    public List<CourseInfo> courseInfo(Integer stuId);
    public void updateEmail(Integer stuId,String email);
}
