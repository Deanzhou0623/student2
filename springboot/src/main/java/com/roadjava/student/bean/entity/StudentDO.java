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

@Data
@TableName("student")
public class StudentDO {
    /*
    * 指定primary key auto_increment
    * */
    @TableId(type = IdType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
