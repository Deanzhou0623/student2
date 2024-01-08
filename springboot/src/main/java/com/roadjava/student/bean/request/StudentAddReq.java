package com.roadjava.student.bean.request;/*
 *ClassName:StudentDO
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-28 22:38
 */

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class StudentAddReq {
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
