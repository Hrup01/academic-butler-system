package com.hrup.academicbutlersystem.controller;

import com.hrup.academicbutlersystem.dto.LoginDTO;
import com.hrup.academicbutlersystem.dto.Result;
import com.hrup.academicbutlersystem.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录认证控制器
 *
 * */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    /**
     * 用户登录接口
     * @param loginDTO 登录数据传输对象，包含用户名、密码和角色信息
     * @return 认证成功返回包含JWT token的结果对象，失败返回错误信息
     */
    @RequestMapping ("/login")
    public Result<String> login(@RequestBody LoginDTO loginDTO){
        String token = authService.login(loginDTO.getUsername(), loginDTO.getPassword(), loginDTO.getRole());
        if (token != null){
             return Result.success(token);
        }
         return Result.error(Result.UNAUTHORIZED, "用户名或密码错误");
    }

    /**
     * 用户登出接口
     * @param request HTTP请求对象，用于获取认证头信息
     * @return 登出成功返回成功信息，失败返回错误信息
     */
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request){
        // 从请求头中获取并解析token
        String token = request.getHeader("Authorization");
        if ( token != null && token.startsWith("Bearer ")){
            token = token.substring(7);
            authService.logout(token);
            return Result.success("登出成功");
        }
        return Result.error(Result.UNAUTHORIZED, "未登录");
    }


}
