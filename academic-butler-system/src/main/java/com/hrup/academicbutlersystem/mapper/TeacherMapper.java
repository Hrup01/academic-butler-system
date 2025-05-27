package com.hrup.academicbutlersystem.mapper;

import com.hrup.academicbutlersystem.pojo.Teacher;
import com.hrup.academicbutlersystem.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    /**
     * 向用户表(t_user)中插入一条用户记录
     * @param user 用户对象，包含以下属性：
     *             username - 用户名
     *             password - 密码
     *             role - 角色
     *             status - 状态
     */
   @Insert("insert into t_user (username,password,role.status)"
           +"values(#{username},#{password}, #{role}, #{status})")
    void insertUser(User user);
    /**
     * 向教师表(t_teacher)中插入一条教师记录
     * @param teacher 教师对象，包含以下属性：
     *                id - 用户ID(关联t_user表)
     *                teacherNo - 教师编号
     *                departmentId - 部门ID
     *                name - 教师姓名
     *                phone - 联系电话
     *                email - 电子邮箱
     */
   @Insert("INSERT INTO t_teacher (id, teacher_no, department_id, name, phone, email) " +
            "VALUES (#{id}, #{teacherNo}, #{departmentId}, #{name}, #{phone}, #{email})")
    void insertTeacher(Teacher teacher);
    /**
     * 根据用户名查询教师详细信息(关联用户表和教师表)
     * @param username 要查询的用户名
     * @return 包含用户和教师信息的复合对象，若未找到则返回null
     */
   @Select("SELECT u.*, t.teacher_no, t.department_id, t.name, t.phone, t.email " +
            "FROM t_user u JOIN t_teacher t ON u.id = t.id WHERE u.username = #{username}")
    Teacher selectByUsername(String username);
    /**
     * 根据用户ID查询教师详细信息(关联用户表和教师表)
     * @param id 要查询的用户ID
     * @return 包含用户和教师信息的复合对象，若未找到则返回null
     */
   @Select("SELECT u.*, t.teacher_no, t.department_id, t.name, t.phone, t.email " +
            "FROM t_user u JOIN t_teacher t ON u.id = t.id WHERE u.id = #{id}")
    Teacher selectById(Long id);
    /**
     * 查询所有教师信息(关联用户表和教师表)
     * @return 包含所有教师信息的列表，列表元素为复合对象(用户+教师信息)
     */
   @Select("SELECT u.*, t.teacher_no, t.department_id, t.name, t.phone, t.email " +
            "FROM t_user u JOIN t_teacher t ON u.id = t.id")
    List<Teacher> selectAll();
    /**
     * 更新用户基础信息
     * @param user 用户实体对象，包含需要更新的字段：
     *             - username: 用户名
     *             - password: 密码
     *             - status: 状态
     *             - id: 用户ID（作为更新条件）
     */
   @Update("update t_user set username=#{username}, password=#{password}, status=#{status} where id=#{id}")
    void updateUser(User user);
   /**
     * 更新教师信息
     * @param teacher 教师实体对象，包含需要更新的字段：
     *                - id: 教师ID（作为更新条件）
     *                - teacher_no: 教师编号
     *                - department_id: 部门ID
     *                - name: 教师姓名
     *                - phone: 联系电话
     *                - email: 邮箱地址
     */
   @Update("update t_teacher set teacher_no=#{teacher_No}, department_id=#{departmentId}" +
           "name=#{name}, phone=#{phone}, email=#{email} WHERE id=#{id}")
    void updateTeacher(Teacher teacher);
    /**
     * 根据用户ID删除用户信息
     * @param id 要删除的用户ID
     */
   @Delete("delete from t_user where id=#{id}")
    void deleteUser(Long id);
   /**
     * 根据用户ID删除教师信息
     * @param id 要删除的教师ID
     */
   @Delete("delete from t_teacher where id=#{id}")
    void deleteTeacher(Long id);
}
