package com.hrup.academicbutlersystem.service.impl;

import com.hrup.academicbutlersystem.exception.BusinessException;
import com.hrup.academicbutlersystem.mapper.CourseMapper;
import com.hrup.academicbutlersystem.mapper.TeacherMapper;
import com.hrup.academicbutlersystem.pojo.Course;
import com.hrup.academicbutlersystem.pojo.Teacher;
import com.hrup.academicbutlersystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    /**
     * 自动注入的教师数据访问接口
     * 用于数据库教师表的CRUD操作
     *
     * 自动注入的课程数据访问接口
     * 用于数据库课程表的CRUD操作
     */
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CourseMapper courseMapper;
    /**根据id从数据库中获取用户信息并封装成Teacher对象返回*/
    @Override
    public Teacher getprofile(Long id) {
        Teacher teacher = teacherMapper.selectById(id);
        if (teacher == null){
            throw new BusinessException("教师不存在");
        }
        return teacher;
    }
    /**
     * 修改教师信息
     **/
    @Override
    public void updateprofile(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }
    /**
     * 获取教师所教课程
     **/
    @Override
    public List<Course> getMycourses(Long teacherId) {
        List<Course> teacherCourses = courseMapper.selectByTeacherId(teacherId);
        return teacherCourses;
    }
}
