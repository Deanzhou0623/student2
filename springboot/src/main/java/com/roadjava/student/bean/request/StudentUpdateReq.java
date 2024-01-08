package com.roadjava.student.bean.request;/*
 *ClassName:StudentUpdateReq
 *Description: update student request
 *@Author:deanzhou
 *@Date:2024-01-07 21:55
 */

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class StudentUpdateReq {
    @NotNull(message = "update student info,there should be student id")
    private Long id;
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
