package com.hrup.academicbutlersystem.service.impl;

import com.hrup.academicbutlersystem.exception.BusinessException;
import com.hrup.academicbutlersystem.mapper.CourseMapper;
import com.hrup.academicbutlersystem.pojo.Course;
import com.hrup.academicbutlersystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    /**
     *添加课程
     * 解析课程对象中的信息
     * 插入到数据库
     **/
    @Override
    public void addCourse(Course course) {
       courseMapper.insert(course);
    }
    /**
     * 根据课程id获取课程信息
     * 并封装成课程对象返回
     * */

    @Override
    public Course getCourseById(Long id) {
        Course course = courseMapper.selectById(id);
        if (course == null){

        }
        return course;
    }
    /**
     * 从数据库获取所有课程信息
     * 封装成课程对象存储到List集合中
     * */

    @Override
    public List<Course> listAllCourses() {
        List<Course> allCourses = courseMapper.selectPublicCourses();
        return allCourses;
    }
    /**
     * 修改课程信息
     * 解析课程对象并把数据库中课程信息进行修改
     * */

    @Override
    public void updateCourse(Course course) {
        courseMapper.update(course);
    }
    /**
     * 根据课程id删除课程
     * */

    @Override
    public void deleteCourse(Long id) {
        courseMapper.delete(id);
    }
    /**
     * 根据教师id获取课程信息
     * 封装成课程对象存储到List集合中
     * */
    @Override
    public List<Course> getCoursesByTeacherId(Long teacherId) {
        return List.of();
    }

    /**
     * 根据学生id获取课程信息
     * 封装成课程对象存储到List集合中
     * */
    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {
        return List.of();
    }

    /**
     * 根据学生id和课程id进行选课
     * */
    @Override
    @Transactional
    public void selectCourse(Long studentId, Long courseId) {
        //判断课程是否已经被选择
        if (courseMapper.countStudentCourse(studentId, courseId) > 0){
            //已被选择
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
