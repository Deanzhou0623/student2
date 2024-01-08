package com.roadjava.student.bean.entity;/*
 *ClassName:StudentDO
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-28 22:38
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@TableName("student")
public class StudentDO {

    /**
     * 指定主键自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /*
    * student number
    * */
    @NotBlank
    private String no;

    /*
    * student name
    * */
    @NotBlank
    private String realName;

    /*
    * enroll time
    * */
    @NotNull
    private Date enrollTime;


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getEnrollTime() {
        return enrollTime;
    }

    public void setEnrollTime(Date enrollTime) {
        this.enrollTime = enrollTime;
    }
}
