package com.hrup.academicbutlersystem.service;


import com.hrup.academicbutlersystem.pojo.Course;
import com.hrup.academicbutlersystem.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    // 添加课程
    void addCourse(Course course);
    // 修改课程信息
    void updateCourse(Course course);
    // 删除课程
    void deleteCourse(Long courseId);
    // 查询课程信息
    List<Course> getCoursesByTeacherId(Long teacherId);
    // 申请课程状态变更
    void applyCourseStatusChange(Long courseId, Integer newStatus);
}
