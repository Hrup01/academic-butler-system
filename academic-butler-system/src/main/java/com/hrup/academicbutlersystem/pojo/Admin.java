package com.hrup.academicbutlersystem.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Admin extends User{
    private String adminNo;//管理员编号
}
