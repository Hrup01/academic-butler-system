package com.hrup.academicbutlersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
    private Long id;//用户id
    private String username;//用户名
    private String password;//密码(加密存储)
    private String role;//角色
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
    /*
    * 状态
    * （0-正常,1-禁用）
    * */
    private Integer status;
}
