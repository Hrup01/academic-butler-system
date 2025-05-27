package com.hrup.academicbutlersystem.service;

import com.hrup.academicbutlersystem.pojo.Course;

import java.util.List;

public interface CourseService {
    void  addCourse(Course course);
    Course getCourseById(Long id);
    List<Course> listAllCourses();
    void updateCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCoursesByTeacherId(Long teacherId);
    List<Course> getCoursesByStudentId(Long studentId);
    void selectCourse(Long studentId, Long courseId);

}
