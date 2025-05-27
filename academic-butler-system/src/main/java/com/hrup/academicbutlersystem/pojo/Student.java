package com.hrup.academicbutlersystem.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends User{
    private String studentNo;//学生工号
    private Long departmentId;//院系id
    private Long majorId;//专业id
    private String className;//课程名
    private String name;//学生姓名
    private String phone;//学生电话号
    private String email;//学生邮箱
    private Integer grade;//年级

}
