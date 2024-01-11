package com.roadjava.student.bean.vo;/*
 *ClassName:ScoreVO
 *Description: score object
 *@Author:deanzhou
 *@Date:2024-01-10 19:50
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class ScoreVO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 外键:student表的id
     */
    private Long studentId;
    /*
    * 学生姓名
    * */
    private String studentName;
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
