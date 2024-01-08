package com.roadjava.student.bean.vo;/*
 *ClassName:StudentVO
 *Description: TODO
 *@Author:deanzhou
 *@Date:2024-01-07 20:18
 */

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class StudentVO {

    /**
     * 学号
     */
    @NotBlank
    private String no;

    /**
     * 学生姓名
     */
    @NotBlank
    private String realName;
    /**
     * 入学日期
     */
    @NotNull
    private Date enrollTime;
}
