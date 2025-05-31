package com.hrup.academicbutlersystem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@ApiModel("登录请求参数")
public class LoginDTO {
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", required = true, example = "admin")
    private String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true, example = "123456")
    private String password;

    @NotBlank(message = "角色不能为空")
    @ApiModelProperty(value = "角色(ADMIN/TEACHER/STUDENT)", required = true, example = "ADMIN")
    private String role;

}
