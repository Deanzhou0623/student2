package com.roadjava.student.bean.entity;/*
 *ClassName:ManagerDO
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-28 22:38
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Manager")
public class ManagerDO {
    /*
    * 指定primary key auto_increment
    * */
    @TableId(type = IdType.AUTO)
    private Long id;
    /*
    * username
    * */
    @TableField("user_name")
    private String username;
    /*
    * password
    * */
    private String pwd;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
