package com.hrup.academicbutlersystem.service.impl;

import com.hrup.academicbutlersystem.mapper.CourseMapper;
import com.hrup.academicbutlersystem.mapper.StudentMapper;
import com.hrup.academicbutlersystem.pojo.Course;
import com.hrup.academicbutlersystem.pojo.Student;
import com.hrup.academicbutlersystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public Student getStudentById(Long id) {
        Student student = studentMapper.selectById(id);
        if (student == null){
            //抛出异常
        }
        return student;
    }

    /**
     * 修改学生信息
     * */
    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }
    /**
     * 获取学生课表信息并封装成Course对象存储到List集合中
     * */
    @Override
    public List<Course> getMyCourses(Long studentId) {
        List<Course> studentCourses = courseMapper.selectByStudentId(studentId);
        return studentCourses;
    }
}
