package com.hrup.academicbutlersystem.service;


import com.hrup.academicbutlersystem.pojo.Course;
import com.hrup.academicbutlersystem.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    /**
     * 1.根据教师ID获取教师个人信息
     * 2.更新教师个人信息
     * 3.获取教师所教授的课程列表
     *
     * @param id 教师ID，唯一标识一个教师
     *
     * @return 返回对应ID的教师对象，包含教师详细信息
     * @return 返回该教师教授的所有课程列表
     */
    Teacher getprofile(Long id);
    void updateprofile(Teacher teacher);
    List<Course> getMycourses(Long teacherId);

}
