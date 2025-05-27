package com.hrup.academicbutlersystem.service;

import com.hrup.academicbutlersystem.pojo.User;

public interface AuthService {
    String login(String username, String password,String role);
    void logout();
    User getUserByToken(String token);
}
