/*
Navicat MySQL Data Transfer

Source Server         : connection
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : studentattendancesys

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2015-06-27 08:41:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admininfo`
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_login_pwd` varchar(255) DEFAULT NULL,
  `admin_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admininfo
-- ----------------------------

-- ----------------------------
-- Table structure for `attendanceinfo`
-- ----------------------------
DROP TABLE IF EXISTS `attendanceinfo`;
CREATE TABLE `attendanceinfo` (
  `attendance_id` int(11) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `record_time` date DEFAULT NULL,
  PRIMARY KEY (`attendance_id`),
  KEY `FK_Relationship_5` (`class_id`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`class_id`) REFERENCES `classinfo` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendanceinfo
-- ----------------------------
INSERT INTO `attendanceinfo` VALUES ('1', '1', '2015-06-01');
INSERT INTO `attendanceinfo` VALUES ('2', '2', '2015-06-01');
INSERT INTO `attendanceinfo` VALUES ('3', '3', '2015-06-01');
INSERT INTO `attendanceinfo` VALUES ('4', '4', '2015-06-01');
INSERT INTO `attendanceinfo` VALUES ('5', '5', '2015-06-01');
INSERT INTO `attendanceinfo` VALUES ('6', '1', '2015-06-08');
INSERT INTO `attendanceinfo` VALUES ('7', '2', '2015-06-08');
INSERT INTO `attendanceinfo` VALUES ('8', '3', '2015-06-08');
INSERT INTO `attendanceinfo` VALUES ('9', '4', '2015-06-08');
INSERT INTO `attendanceinfo` VALUES ('10', '5', '2015-06-08');

-- ----------------------------
-- Table structure for `attendancerecord`
-- ----------------------------
DROP TABLE IF EXISTS `attendancerecord`;
CREATE TABLE `attendancerecord` (
  `stu_student_id` int(11) NOT NULL,
  `att_attendance_id` int(11) NOT NULL,
  `attendanceRecord_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `attendance_id` int(11) DEFAULT NULL,
  `attendance_status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stu_student_id`,`att_attendance_id`),
  KEY `FK_attendancerecord2` (`att_attendance_id`),
  CONSTRAINT `FK_attendancerecord` FOREIGN KEY (`stu_student_id`) REFERENCES `studentinfo` (`student_id`),
  CONSTRAINT `FK_attendancerecord2` FOREIGN KEY (`att_attendance_id`) REFERENCES `attendanceinfo` (`attendance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendancerecord
-- ----------------------------
INSERT INTO `attendancerecord` VALUES ('1', '1', '1', '1', '1', '迟到');
INSERT INTO `attendancerecord` VALUES ('1', '2', '2', '1', '2', '旷到');
INSERT INTO `attendancerecord` VALUES ('1', '3', '3', '1', '3', '早退');
INSERT INTO `attendancerecord` VALUES ('1', '4', '4', '1', '4', '正常');
INSERT INTO `attendancerecord` VALUES ('1', '5', '5', '1', '5', '迟到');
INSERT INTO `attendancerecord` VALUES ('1', '6', '6', '1', '6', '正常');
INSERT INTO `attendancerecord` VALUES ('1', '7', '7', '1', '7', '早退');
INSERT INTO `attendancerecord` VALUES ('1', '8', '8', '1', '8', '正常');
INSERT INTO `attendancerecord` VALUES ('1', '9', '9', '1', '9', '正常');
INSERT INTO `attendancerecord` VALUES ('1', '10', '10', '1', '10', '正常');
INSERT INTO `attendancerecord` VALUES ('2', '1', '1', '2', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('2', '2', '2', '2', '2', '正常');
INSERT INTO `attendancerecord` VALUES ('2', '3', '3', '2', '3', '正常');
INSERT INTO `attendancerecord` VALUES ('2', '4', '4', '2', '4', '正常');
INSERT INTO `attendancerecord` VALUES ('2', '5', '5', '2', '5', '迟到');
INSERT INTO `attendancerecord` VALUES ('2', '6', '6', '2', '6', '正常');
INSERT INTO `attendancerecord` VALUES ('2', '7', '7', '2', '7', '正常');
INSERT INTO `attendancerecord` VALUES ('2', '8', '8', '2', '8', '旷到');
INSERT INTO `attendancerecord` VALUES ('2', '9', '9', '2', '9', '正常');
INSERT INTO `attendancerecord` VALUES ('2', '10', '10', '2', '10', '早退');

-- ----------------------------
-- Table structure for `classinfo`
-- ----------------------------
DROP TABLE IF EXISTS `classinfo`;
CREATE TABLE `classinfo` (
  `class_id` int(11) NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(100) DEFAULT NULL,
  `class_start_week` int(11) DEFAULT NULL,
  `class_end_week` int(11) DEFAULT NULL,
  `class_time` date DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `FK_Relationship_4` (`teacher_id`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`teacher_id`) REFERENCES `teacherinfo` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classinfo
-- ----------------------------
INSERT INTO `classinfo` VALUES ('1', '1', '1', '数据结构', '1', '16', '2015-03-13');
INSERT INTO `classinfo` VALUES ('2', '2', '2', '数据库', '1', '16', '2015-03-14');
INSERT INTO `classinfo` VALUES ('3', '3', '3', 'java', '1', '16', '2015-03-15');
INSERT INTO `classinfo` VALUES ('4', '4', '4', '综合英语', '1', '16', '2015-03-16');
INSERT INTO `classinfo` VALUES ('5', '5', '5', '英语视听说', '1', '16', '2015-03-17');

-- ----------------------------
-- Table structure for `classstudentinfo`
-- ----------------------------
DROP TABLE IF EXISTS `classstudentinfo`;
CREATE TABLE `classstudentinfo` (
  `stu_student_id` int(11) NOT NULL,
  `cla_class_id` int(11) NOT NULL,
  `classStu_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`stu_student_id`,`cla_class_id`),
  KEY `FK_classstudentinfo2` (`cla_class_id`),
  CONSTRAINT `FK_classstudentinfo` FOREIGN KEY (`stu_student_id`) REFERENCES `studentinfo` (`student_id`),
  CONSTRAINT `FK_classstudentinfo2` FOREIGN KEY (`cla_class_id`) REFERENCES `classinfo` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classstudentinfo
-- ----------------------------
INSERT INTO `classstudentinfo` VALUES ('1', '1', '1', '1', '1');
INSERT INTO `classstudentinfo` VALUES ('1', '2', '2', '2', '1');
INSERT INTO `classstudentinfo` VALUES ('3', '3', '3', '3', '1');
INSERT INTO `classstudentinfo` VALUES ('4', '4', '4', '4', '1');
INSERT INTO `classstudentinfo` VALUES ('5', '5', '5', '5', '1');

-- ----------------------------
-- Table structure for `collegeinfo`
-- ----------------------------
DROP TABLE IF EXISTS `collegeinfo`;
CREATE TABLE `collegeinfo` (
  `college_name` varchar(100) NOT NULL,
  `college_address` varchar(100) DEFAULT NULL,
  `college_contact` varchar(100) DEFAULT NULL,
  `college_tel` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`college_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collegeinfo
-- ----------------------------
INSERT INTO `collegeinfo` VALUES ('传媒艺术学院', '八教', '无', '5555555');
INSERT INTO `collegeinfo` VALUES ('外国语学院', '五教', '无', '3333333');
INSERT INTO `collegeinfo` VALUES ('经济管理学院', '经管', '无', '4444444');
INSERT INTO `collegeinfo` VALUES ('计算机科学与技术学院', '二教', '无', '2222222');
INSERT INTO `collegeinfo` VALUES ('软件工程学院', '二教', '无', '1111111');

-- ----------------------------
-- Table structure for `facultyinfo`
-- ----------------------------
DROP TABLE IF EXISTS `facultyinfo`;
CREATE TABLE `facultyinfo` (
  `faculty_name` varchar(100) NOT NULL,
  `faculty_address` varchar(100) DEFAULT NULL,
  `faculty_contact` varchar(100) DEFAULT NULL,
  `faculty_tel` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`faculty_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of facultyinfo
-- ----------------------------
INSERT INTO `facultyinfo` VALUES ('产学研', '产学研处', '无', '2222');
INSERT INTO `facultyinfo` VALUES ('图书馆', '二教对面', '无', '2222');
INSERT INTO `facultyinfo` VALUES ('学生处', '千喜鹤', '无', '2222');
INSERT INTO `facultyinfo` VALUES ('教务处', '千喜鹤', '无', '2222');
INSERT INTO `facultyinfo` VALUES ('武装部', '老图后面', '无', '2222');

-- ----------------------------
-- Table structure for `studentinfo`
-- ----------------------------
DROP TABLE IF EXISTS `studentinfo`;
CREATE TABLE `studentinfo` (
  `student_id` int(11) NOT NULL,
  `college_name` varchar(100) DEFAULT NULL,
  `student_name` varchar(100) DEFAULT NULL,
  `student_login_pwd` varchar(100) DEFAULT NULL,
  `student_college` varchar(100) DEFAULT NULL,
  `student_major` varchar(100) DEFAULT NULL,
  `student_email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FK_Relationship_1` (`college_name`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`college_name`) REFERENCES `collegeinfo` (`college_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentinfo
-- ----------------------------
INSERT INTO `studentinfo` VALUES ('1', '软件工程学院', '张三', '123', '软件工程学院', '英语+软件', '663287823@qq.com');
INSERT INTO `studentinfo` VALUES ('2', '外国语学院', '小红', '123', '外国语学院', '英语类', '6666@qq.com');
INSERT INTO `studentinfo` VALUES ('3', '经济管理学院', '小兰', '123', '经济管理学院', '会计学', '666666666@qq.com');
INSERT INTO `studentinfo` VALUES ('4', '计算机科学与技术学院', '赵四', '123', '计算机科学与技术学院', '计算机科学与技术', '666666666@qq.com');
INSERT INTO `studentinfo` VALUES ('5', '传媒艺术学院', '小芳', '123', '传媒艺术学院', '动画', '666666666@qq.com');

-- ----------------------------
-- Table structure for `teacherinfo`
-- ----------------------------
DROP TABLE IF EXISTS `teacherinfo`;
CREATE TABLE `teacherinfo` (
  `teacher_id` int(11) NOT NULL,
  `college_name` varchar(100) DEFAULT NULL,
  `faculty_name` varchar(100) DEFAULT NULL,
  `teacher_name` varchar(100) DEFAULT NULL,
  `teacher_login_pwd` varchar(100) DEFAULT NULL,
  `teacher_email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `FK_Relationship_2` (`college_name`),
  KEY `FK_Relationship_3` (`faculty_name`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`college_name`) REFERENCES `collegeinfo` (`college_name`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`faculty_name`) REFERENCES `facultyinfo` (`faculty_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacherinfo
-- ----------------------------
INSERT INTO `teacherinfo` VALUES ('1', '软件工程学院', '产学研', '何物', '123', '666666666@qq.com');
INSERT INTO `teacherinfo` VALUES ('2', '传媒艺术学院', '图书馆', '小云', '123', '666666666@qq.com');
INSERT INTO `teacherinfo` VALUES ('3', '外国语学院', '学生处', '朱军', '123', '666666666@qq.com');
INSERT INTO `teacherinfo` VALUES ('4', '经济管理学院', '教务处', '董沁', '123', '666666666@qq.com');
INSERT INTO `teacherinfo` VALUES ('5', '计算机科学与技术学院', '武装部', '王宝强', '123', '666666666@qq.com');
