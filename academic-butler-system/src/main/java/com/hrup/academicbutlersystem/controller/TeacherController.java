package com.hrup.academicbutlersystem.controller;

import com.hrup.academicbutlersystem.dto.Result;
import com.hrup.academicbutlersystem.pojo.Course;
import com.hrup.academicbutlersystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TEACHER")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 添加课程
     * */
    @PostMapping("/addCourse")
    public Result<String> addCourse(@RequestBody Course course){
        teacherService.addCourse(course);
        return Result.success("课程添加成功");
    }

    /**
     * 修改课程信息
     * */
    @PutMapping("/updateCourse")
    public Result<String> updateCourse(@RequestBody Course course){
        teacherService.updateCourse(course);
        return Result.success("课程修改成功");
    }

    /**
     * 删除课程
     * */
    @DeleteMapping("/deleteCourse/{courseId}")
    public Result<String> deleteCourse(Long courseId){
        teacherService.deleteCourse(courseId);
        return Result.success("课程删除成功");
    }
    /**
     * 查询课程信息
     * */
    @GetMapping("getcourse/{teacherId}")
    public Result<List<Course>> getCoutsesByTeacherId(@RequestBody Long teacherId){
        List<Course> coursesByTeacherId = teacherService.getCoursesByTeacherId(teacherId);
        return Result.success(coursesByTeacherId);
    }
    /**
     * 申请课程状态改变
     * */
    public Result<String> applyCourseStatusChange(@RequestBody Long courseId,@RequestBody Integer newStatus){
        teacherService.applyCourseStatusChange(courseId,newStatus);
        return Result.success("课程状态改变申请已提交");
    }

}
