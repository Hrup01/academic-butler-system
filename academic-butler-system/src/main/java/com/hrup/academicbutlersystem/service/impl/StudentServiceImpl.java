package com.hrup.academicbutlersystem.service.impl;

import com.hrup.academicbutlersystem.exception.BusinessException;
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
            throw new BusinessException("学生不存在");//抛出异常
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

    /**
     * 根据学生id和课程id来进行选课
     * */
    @Override
    public void selectCourse(Long studentId, Long courseId) {
        if (courseMapper.countStudentCourse( studentId, courseId) > 0){
            throw new BusinessException("该课程已经被选择");
        }
        Course course = courseMapper.selectById(courseId);
         /** 课程状态(1-已提交,2-审核通过,3-审核不通过,4-公开,5-隐藏) */
          if (course == null || course.getStatus() != 4){
               throw new BusinessException("课程不可选择");//抛出课程不可选择异常
          }
           //根据学生id和课程id插入相应课程进入学生课表中
         courseMapper.insertStudentCourse(studentId, courseId);
    }
}
