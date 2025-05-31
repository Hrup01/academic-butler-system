package com.hrup.academicbutlersystem.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * JWT工具类，用于生成、解析和验证JWT令牌
 * 使用Spring的@Component注解标记为Spring组件，可通过依赖注入使用
 */
@Component
public class JWTUtils {
    @Value("${jwt.secret}")
    private String secret;//JWT签名密钥，从配置文件中注入

    @Value("${jwt.expiration}")
    private Long expiration;//JWT过期时间（秒），从配置文件中注入


    //添加黑名单管理
    private static Set<String> tokenBlackList = new HashSet<>();
    public void invalidateToken(String token){
        tokenBlackList.add(token);
    }
    public boolean isTokenInvalid(String token){
        return tokenBlackList.contains(token);
    }

    /**
     * 生成JWT令牌
     * @param username 用户名，将作为JWT的主题(subject)
     * @param role 用户角色，将作为自定义声明(claim)存入令牌
     * @return 生成的JWT字符串
     *
     * 令牌包含以下信息：
     * - 自定义声明：用户角色
     * - 主题：用户名
     * - 签发时间：当前时间
     * - 过期时间：当前时间 + 配置的过期时间
     * - 签名算法：HS512
     */
    public String generateToken(String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 从JWT令牌中解析声明(Claims)
     * @param token JWT令牌字符串
     * @return 包含所有声明的Claims对象
     * @throws 如果令牌无效或过期会抛出异常
     */
    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
    /**
     * 验证JWT令牌是否有效
     * @param token 待验证的JWT令牌
     * @return true-令牌有效，false-令牌无效或过期
     */

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 从JWT令牌中获取用户名(主题)
     * @param token JWT令牌字符串
     * @return 用户名
     */

    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }
    /**
     * 从JWT令牌中获取用户角色
     * @param token JWT令牌字符串
     * @return 用户角色字符串
     */

    public String getRoleFromToken(String token) {
        return (String) getClaimsFromToken(token).get("role");
    }
}
