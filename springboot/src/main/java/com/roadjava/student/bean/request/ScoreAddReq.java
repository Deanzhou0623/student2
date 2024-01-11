package com.roadjava.student.bean.request;/*
 *ClassName:scoreAddReq
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-28 22:38
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ScoreAddReq {
    /**
     * 外键:student表的id
     */
    @NotNull
    private Long studentId;
    /**
     * 考试名称
     */
    @NotBlank
    private String examName;
    /**
     * 语文成绩
     */
    @NotNull
    private Double cnScore;
    /**
     * 英语成绩
     */
    @NotNull
    private Double enScore;
    /**
     * 数学成绩
     */
    @NotNull
    private Double mathScore;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Double getCnScore() {
        return cnScore;
    }

    public void setCnScore(Double cnScore) {
        this.cnScore = cnScore;
    }

    public Double getEnScore() {
        return enScore;
    }

    public void setEnScore(Double enScore) {
        this.enScore = enScore;
    }

    public Double getMathScore() {
        return mathScore;
    }

    public void setMathScore(Double mathScore) {
        this.mathScore = mathScore;
    }
}
