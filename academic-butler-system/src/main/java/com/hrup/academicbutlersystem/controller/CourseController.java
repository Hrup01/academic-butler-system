package com.hrup.academicbutlersystem.controller;

import com.hrup.academicbutlersystem.dto.Result;
import com.hrup.academicbutlersystem.pojo.Course;
import com.hrup.academicbutlersystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 添加课程
     * @param course 课程对象
     * @return 操作结果
     */
    @PostMapping
    public Result<String> addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return Result.success("课程添加成功");
    }

    /**
     * 根据课程ID获取课程信息
     * @param id 课程ID
     * @return 课程信息
     */
    @GetMapping("/{id}")
    public Result<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        if (course == null) {
            return Result.error(Result.NOT_FOUND, "课程不存在");
        }
        return Result.success(course);
    }

    /**
     * 获取所有公开课程列表
     * @return 公开课程列表
     */
    @GetMapping
    public Result<List<Course>> listAllCourses() {
        List<Course> courses = courseService.listAllCourses();
        return Result.success(courses);
    }

    /**
     * 修改课程信息
     * @param course 课程对象
     * @return 操作结果
     */
    @PutMapping
    public Result<String> updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
        return Result.success("课程信息修改成功");
    }

    /**
     * 根据课程ID删除课程
     * @param id 课程ID
     * @return 操作结果
     */
    @DeleteMapping("/{id}")
    public Result<String> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return Result.success("课程删除成功");
    }

    /**
     * 根据教师ID获取该教师教授的课程列表
     * @param teacherId 教师ID
     * @return 课程列表
     */
    @GetMapping("/teacher/{teacherId}")
    public Result<List<Course>> getCoursesByTeacherId(@PathVariable Long teacherId) {
        List<Course> courses = courseService.getCoursesByTeacherId(teacherId);
        return Result.success(courses);
    }

    /**
     * 根据学生ID获取该学生选的课程列表
     * @param studentId 学生ID
     * @return 课程列表
     */
    @GetMapping("/student/{studentId}")
    public Result<List<Course>> getCoursesByStudentId(@PathVariable Long studentId) {
        List<Course> courses = courseService.getCoursesByStudentId(studentId);
        return Result.success(courses);
    }

    /**
     * 学生选课
     * @param studentId 学生ID
     * @param courseId 课程ID
     * @return 操作结果
     */
    @PostMapping("/student/{studentId}/{courseId}")
    public Result<String> selectCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        courseService.selectCourse(studentId, courseId);
        return Result.success("选课成功");
    }
}
