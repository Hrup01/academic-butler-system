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

    @Autowired
    private CourseMapper courseMapper;
    /**
     * 添加课程信息
     * @param course 课程对象，包含课程详细信息
     */
    @Override
    public void addCourse(Course course) {
        courseMapper.insert(course);
    }

    /**
     * 更新课程信息
     * @param course 课程对象，包含需要更新的课程信息
     */

    @Override
    public void updateCourse(Course course) {
        courseMapper.update(course);
    }
    /**
     * 删除指定课程
     * @param courseId 课程ID，唯一标识一个课程
     */

    @Override
    public void deleteCourse(Long courseId) {
        courseMapper.delete(courseId);
    }
    /**
     * 根据教师ID获取其负责的课程列表
     * @param teacherId 教师ID，唯一标识一个教师
     * @return 该教师负责的课程列表，若无则返回空列表
     */

    @Override
    public List<Course> getCoursesByTeacherId(Long teacherId) {
        List<Course> coursesByTeacher = courseMapper.selectByTeacherId(teacherId);
        return coursesByTeacher;
    }
    /**
     * 申请变更课程状态
     * @param courseId 课程ID，唯一标识一个课程
     * @param newStatus 新的课程状态值
     * @throws BusinessException 当课程不存在时抛出异常
     */

    @Override
    public void applyCourseStatusChange(Long courseId, Integer newStatus) {
        Course course = courseMapper.selectById(courseId);
        if ( course == null){
             throw new BusinessException("课程不存在");
        }
         courseMapper.updateStatus(courseId, newStatus);
    }
}
