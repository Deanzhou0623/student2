package com.roadjava.student.bean.request;/*
 *ClassName:ScoreUpdateReq
 *Description: update student request
 *@Author:deanzhou
 *@Date:2024-01-07 21:55
 */

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ScoreUpdateReq {
    @NotNull(message = "there should be score id")
    private Long id;
    
    /**
     * 外键:student表的id
     */
    @NotNull
    private Long studentId;

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
