package com.hrup.academicbutlersystem.service;

import com.hrup.academicbutlersystem.pojo.Course;
import com.hrup.academicbutlersystem.pojo.Student;

import java.util.List;

public interface StudentService {
    /**
     * 1. 根据id查询学生信息
     * 2. 根据id修改学生信息
     * 3. 根据学生id获取到学生的课程
     * 4.选课业务
     * */
    Student getStudentById(Long id);
    void updateStudent(Student student);
    List<Course> getMyCourses(Long studentId);
    void selectCourse(Long studentId, Long courseId);
}
