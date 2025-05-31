package com.hrup.academicbutlersystem.controller;

import com.hrup.academicbutlersystem.dto.Result;
import com.hrup.academicbutlersystem.pojo.Course;
import com.hrup.academicbutlersystem.pojo.Student;
import com.hrup.academicbutlersystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 学生信息Controller
 * 提供学生相关信息的RESTful API接口
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    /**
     * 根据学生id查询到学生的个人信息
     *
     * */
    @GetMapping("/{StudentId}")
    public Result<Student> getStudentById(@PathVariable Long StudentId){
        Student student = studentService.getStudentById(StudentId);
        return Result.success(student);
    }
    /**
     * 修改学生个人信息
     * */
    @PutMapping("/")
    public Result<String> updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
         return Result.success("修改成功");
    }

    /**
     * 查询课表
     * */
    @GetMapping("/{studentId}/courses")
    public  Result<List<Course>> getMyCourses(@RequestBody Long studentId){
        List<Course> courses = studentService.getMyCourses(studentId);
        return Result.success(courses);
    }
    /**
     * 选课
     **/
    public Result<String> selectCourse(@PathVariable Long studentId,@PathVariable Long courseId){
        studentService.selectCourse(studentId, courseId);
        return Result.success("选课成功");
    }

}
