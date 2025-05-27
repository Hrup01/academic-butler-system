package com.hrup.academicbutlersystem.service.impl;

import com.hrup.academicbutlersystem.mapper.CourseMapper;
import com.hrup.academicbutlersystem.mapper.StudentMapper;
import com.hrup.academicbutlersystem.mapper.TeacherMapper;
import com.hrup.academicbutlersystem.pojo.User;
import com.hrup.academicbutlersystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    private CourseMapper courseMapper;
//    @Autowired
//    private AdminMapper adminMapper;
    @Override
    public String login(String username, String password, String role) {
        return "";
    }

    @Override
    public void logout() {

    }

    @Override
    public User getUserByToken(String token) {
        return null;
    }
}
