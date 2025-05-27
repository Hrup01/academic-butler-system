package com.hrup.academicbutlersystem.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/*
*教师实体类
* */
@Data
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User {
    /** 教师工号 */
    private String teacherNo;
    /** 所属院系ID */
    private Long departmentId;
    /** 教师姓名 */
    private String name;
    /** 联系电话 */
    private String phone;
    /** 邮箱 */
    private String email;
}
