package com.hrup.academicbutlersystem.mapper;

import com.hrup.academicbutlersystem.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    /**
     * 插入课程信息到数据库
     * @param course 课程对象，包含课程编号、名称、教师ID、专业ID等信息
     */
    @Insert("INSERT INTO t_course (course_no, course_name, teacher_id, major_id, grade, " +
            "course_type, credit, is_public, status) " +
            "VALUES (#{courseNo}, #{courseName}, #{teacherId}, #{majorId}, #{grade}, " +
            "#{courseType}, #{credit}, #{isPublic}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Course course);

    /**
     * 根据课程编号查询课程信息
     * @param courseNo 课程编号
     * @return 课程对象，包含课程编号、名称、教师ID、专业ID等信息
     */
    @Select("SELECT * FROM t_course WHERE id = #{id}")
    Course selectById(Long id);

    /**
     * 根据教师ID查询该教师教授的课程列表
     * @param teacherId 教师ID
     * @return 课程列表
     */
    @Select("SELECT * FROM t_course WHERE teacher_id = #{teacherId}")
    List<Course> selectByTeacherId(Long teacherId);

    /**
     * 根据学生ID查询该学生选的课程列表
     * @param studentId 学生ID
     * @return 课程列表
     */
    @Select("SELECT c.* FROM t_course c JOIN t_student_course sc ON c.id = sc.course_id " +
            "WHERE sc.student_id = #{studentId}")
    List<Course> selectByStudentId(Long studentId);

    /**
     * 查询所有公开课程列表
     * @return 公开课程列表
     */
    @Select("SELECT * FROM t_course WHERE status = 4") // 公开课程
    List<Course> selectPublicCourses();

    /**
     * 更新课程信息
     * @param course 课程对象，包含课程编号、名称、教师ID、专业ID等信息
     */
    @Update("UPDATE t_course SET course_no=#{courseNo}, course_name=#{courseName}, " +
            "teacher_id=#{teacherId}, major_id=#{majorId}, grade=#{grade}, " +
            "course_type=#{courseType}, credit=#{credit}, is_public=#{isPublic}, " +
            "status=#{status} WHERE id=#{id}")
    void update(Course course);

    /**
     * 更新课程状态
     * @param id 课程ID
     * @param status 课程状态
     */
    @Update("UPDATE t_course SET status=#{status} WHERE id=#{id}")
    void updateStatus(@Param("id") Long id, @Param("status") Integer status);

    /**
     * 删除课程信息
     * @param id 课程ID
     */
    @Delete("DELETE FROM t_course WHERE id = #{id}")
    void delete(Long id);

    /**
     * 插入学生选课记录
     * @param studentId 学生ID
     * @param courseId 课程ID
     */
    @Insert("INSERT INTO t_student_course (student_id, course_id) VALUES (#{studentId}, #{courseId})")
    void insertStudentCourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

    /**
     * 统计学生是否已选某课程
     * @param studentId 学生ID
     * @param courseId 课程ID
     * @return 选课记录数量(0表示未选)
     */
    @Select("SELECT COUNT(*) FROM t_student_course WHERE student_id = #{studentId} AND course_id = #{courseId}")
    int countStudentCourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId);
}
