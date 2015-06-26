package com.wzy.model;

import com.wzy.bean.CourseInfo;
import com.wzy.bean.SelectInfo;
import com.wzy.bean.StudentInfo;
import com.wzy.bean.TeacherInfo;
import com.wzy.util.JDBCMysqlUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Y_Y DE YI on 2015/6/25.
 */
public class StudentDaoImp implements StudentDao {
    @Override
    public boolean studentLogin(Integer student_id, String student_login_pwd) {
        boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from studentinfo where student_id=" +"'"+ student_id+"'"
                + "and" +" " + "student_login_pwd=" + "'"+student_login_pwd+"'";
        try {
            con = JDBCMysqlUtil.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public List<SelectInfo> couseIdSelect(Integer stuId,Integer courseId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT record_time,course_name,attendance_status from classinfo,attendanceinfo,attendancerecord where classinfo.class_id=attendanceinfo.class_id and attendanceinfo.attendance_id=attendanceRecord.attendance_id and student_id="+"'"+ stuId+"'" + "and" +" " + "course_id=" + "'"+courseId+"'";
        List<SelectInfo> selectInfos = new ArrayList<SelectInfo>();
        try {
            con = JDBCMysqlUtil.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                SelectInfo selectInfo = new SelectInfo();
                selectInfo.setRecord_time(rs.getString("record_time"));
                selectInfo.setCourse_name(rs.getString("course_name"));
                selectInfo.setAttendance_status(rs.getString("attendance_status"));
                selectInfos.add(selectInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (ps!= null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return selectInfos;
    }

    @Override
    public List<StudentInfo> personInfo(Integer stuId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * from studentinfo where student_id="+"'"+ stuId+"'" ;
        List<StudentInfo> personInfos = new ArrayList<StudentInfo>();
        try {
            con = JDBCMysqlUtil.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                StudentInfo studentinfo = new StudentInfo();
                studentinfo.setStudent_id(rs.getInt("student_id"));
                studentinfo.setStudent_name(rs.getString("student_name"));
                studentinfo.setStudent_college(rs.getString("student_college"));
                studentinfo.setStudent_major(rs.getString("student_major"));
                studentinfo.setStudent_email(rs.getString("student_email"));
                personInfos.add(studentinfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (ps!= null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return personInfos;
    }

    @Override
    public void updatePwd(Integer stuId, String newPwd) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update studentinfo set student_login_pwd="+"'"+newPwd+"'"+" where student_id=" + stuId;
        try {
            con = JDBCMysqlUtil.getConnect();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps!= null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<TeacherInfo> teacherInfo(Integer stuId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT teacher_name,course_name,college_name from teacherinfo,classinfo,classstudentinfo WHERE teacherinfo.teacher_id=classinfo.teacher_id and classinfo.class_id=classstudentinfo.class_id AND student_id="+"'"+stuId+"'";
        List<TeacherInfo> teacherInfos = new ArrayList<TeacherInfo>();
        try {
            con = JDBCMysqlUtil.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                TeacherInfo teacherInfo = new TeacherInfo();
                teacherInfo.setTeacher_name(rs.getString("teacher_name"));
                teacherInfo.setCourse_name(rs.getString("course_name"));
                teacherInfo.setCollege_name(rs.getString("college_name"));
                teacherInfos.add(teacherInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (ps!= null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return teacherInfos;
    }

    @Override
    public List<CourseInfo> courseInfo(Integer stuId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT course_name,class_time,teacher_name,class_end_week from teacherinfo,classinfo,classstudentinfo WHERE teacherinfo.teacher_id=classinfo.teacher_id and classinfo.class_id=classstudentinfo.class_id AND student_id="+"'"+stuId+"'";
        List<CourseInfo> courseInfos = new ArrayList<CourseInfo>();
        try {
            con = JDBCMysqlUtil.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                CourseInfo courseInfo = new CourseInfo();
                courseInfo.setCourse_name(rs.getString("course_name"));
                courseInfo.setClass_time(rs.getString("class_time"));
                courseInfo.setTeacher_name(rs.getString("teacher_name"));
                courseInfo.setClass_end_week(rs.getString("class_end_week"));
                courseInfos.add(courseInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (ps!= null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return courseInfos;

    }

    @Override
    public void updateEmail(Integer stuId, String email) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update studentinfo set student_email="+"'"+email+"'"+" where student_id=" + stuId;
        try {
            con = JDBCMysqlUtil.getConnect();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps!= null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
