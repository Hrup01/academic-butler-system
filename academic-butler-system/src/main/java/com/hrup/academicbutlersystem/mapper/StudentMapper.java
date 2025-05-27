package com.hrup.academicbutlersystem.mapper;

import com.hrup.academicbutlersystem.pojo.Student;
import com.hrup.academicbutlersystem.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 插入用户信息到t_user表
     * @param user 用户对象，包含用户名、密码、角色和状态等信息
     * 注意：使用@Options注解自动生成主键id并回填到user对象中
     */
    @Insert("insert into t_user(username,password,role,status)"+
            "values (#{username},#{password},#{role},#{status})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insertUser(User user);
    /**
     * 插入学生信息到t_student表
     * @param student 学生对象，包含学生编号、部门ID、专业ID、班级名称、姓名、手机号、邮箱、年级等信息
     */
    @Insert("INSERT INTO t_student (id, student_no, department_id, major_id, class_name, name, phone, email, grade) " +
            "VALUES (#{id}, #{studentNo}, #{departmentId}, #{majorId}, #{className}, #{name}, #{phone}, #{email}, #{grade})")
    void insertStudent(Student student);

    /**
     * 根据用户名查询学生完整信息（关联t_user和t_student表）
     * @param username 用户名
     * @return 包含用户基础信息和学生详细信息的复合对象
     */
    @Select("SELECT u.*, s.student_no, s.department_id, s.major_id, s.class_name, s.name, s.phone, s.email, s.grade " +
            "FROM t_user u JOIN t_student s ON u.id = s.id WHERE u.username = #{username}")
    Student selectByUsername(String username);

    /**
     * 根据ID查询学生完整信息（关联t_user和t_student表）
     * @param id 学生ID
     * @return 符合学生完整信息的复合对象
     */
    @Select("SELECT u.*, s.student_no, s.department_id, s.major_id, s.class_name, s.name, s.phone, s.email, s.grade " +
            "FROM t_user u JOIN t_student s ON u.id = s.id WHERE u.id = #{id}")
    Student selectById(Long id);

    /**
     * 查询所有学生完整信息列表（关联t_user和t_student表）
     * @return 学生信息列表
     */
    @Select("SELECT u.*, s.student_no, s.department_id, s.major_id, s.class_name, s.name, s.phone, s.email, s.grade " +
            "FROM t_user u JOIN t_student s ON u.id = s.id")
    List<Student> selectAll();

    /**
     * 更新用户基础信息
     * @param user 包含待更新字段的用户对象
     */
    @Update("UPDATE t_user SET username=#{username}, password=#{password}, status=#{status} WHERE id=#{id}")
    void updateUser(User user);

    /**
     * 更新学生详细信息
     * @param student 包含待更新字段的学生对象
     */
    @Update("UPDATE t_student SET student_no=#{studentNo}, department_id=#{departmentId}, major_id=#{majorId}, " +
            "class_name=#{className}, name=#{name}, phone=#{phone}, email=#{email}, grade=#{grade} WHERE id=#{id}")
    void updateStudent(Student student);

    /**
     * 根据ID删除用户信息（级联删除依赖此ID的其他表数据需由数据库约束或业务逻辑保证）
     * @param id 用户ID
     */
    @Delete("DELETE FROM t_user WHERE id=#{id}")
    void deleteUser(Long id);

    /**
     * 根据ID删除学生信息（级联删除依赖此ID的其他表数据需由数据库约束或业务逻辑保证）
     * @param id 学生ID
     */
    @Delete("DELETE FROM t_student WHERE id=#{id}")
    void deleteStudent(Long id);

}
