package com.roadjava.student.bean.entity;/*
 *ClassName:ScoreDO
 *Description: score object
 *@Author:deanzhou
 *@Date:2024-01-10 19:50
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("score")
public class ScoreDO {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 外键:student表的id
     */
    private Long studentId;
    /**
     * 考试名称
     */
    private String examName;
    /**
     * 语文成绩
     */
    private Double cnScore;
    /**
     * 英语成绩
     */
    private Double enScore;
    /**
     * 数学成绩
     */
    private Double mathScore;
}
