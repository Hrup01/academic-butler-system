package com.hrup.academicbutlersystem.service.impl;

import com.hrup.academicbutlersystem.config.JWTUtils;
import com.hrup.academicbutlersystem.exception.BusinessException;
import com.hrup.academicbutlersystem.mapper.CourseMapper;
import com.hrup.academicbutlersystem.mapper.StudentMapper;
import com.hrup.academicbutlersystem.mapper.TeacherMapper;
import com.hrup.academicbutlersystem.pojo.Student;
import com.hrup.academicbutlersystem.pojo.Teacher;
import com.hrup.academicbutlersystem.pojo.User;
import com.hrup.academicbutlersystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现登录登出以及令牌验证功能的实现类
 *
 * */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private JWTUtils jwtUtils;

//    @Autowired
//    private AdminMapper adminMapper;

    /**
     * 用户登录方法
     * @param username 用户名
     * @param password 密码
     * @param role 用户角色(TEACHER/STUDENT)
     * @return 登录成功返回JWT令牌，失败返回null
     */
    @Override
    public String login(String username, String password, String role) {
        User user = null;
        switch (role) {
            case "TEACHER":
                Teacher teacher = teacherMapper.selectByUsername(username);
                if (teacher != null && teacher.getPassword().equals(password)){
                    user = teacher;
                }
                break;
            case "STUDENT":
                user = studentMapper.selectByUsername(username);
                Student student = studentMapper.selectByUsername(username);
                if (student != null && student.getPassword().equals(password)){
                    user = student;
                }
                break;
            default:
                throw new BusinessException("角色错误");
        }
        if (user == null){
            throw new BusinessException("用户名或密码错误");
        }
        if (user.getStatus() == 1){
            throw new BusinessException("用户被禁用");
        }
        //验证通过后生成JWT令牌
        if (user != null){
            return jwtUtils.generateToken(username, role);
        }
        return null;
    }

    //登出时把令牌加入黑名单实现简单的登录功能
    @Override
    public void logout(String token) {
        jwtUtils.invalidateToken(token);
    }




    /**
     * 通过令牌获取用户信息
     * @param token JWT令牌
     * @return 验证成功返回用户对象，失败返回null
     */

    @Override
    public User getUserByToken(String token) {
        if (jwtUtils.validateToken(token)){
            String username = jwtUtils.getUsernameFromToken(token);
            String role = jwtUtils.getRoleFromToken(token);
            switch (role){
                case "TEACHER":
                    return teacherMapper.selectByUsername(username);
                case "STUDENT":
                    return studentMapper.selectByUsername(username);
            }
        }
        return null;
    }
}
