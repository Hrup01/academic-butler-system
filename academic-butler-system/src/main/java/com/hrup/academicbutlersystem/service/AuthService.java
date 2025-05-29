package com.hrup.academicbutlersystem.service;

import com.hrup.academicbutlersystem.pojo.User;

import java.util.Map;

public interface AuthService {
    String login(String username, String password,String role);
    void logout(String username);
    User getUserByToken(String token);
}
