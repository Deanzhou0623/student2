package com.roadjava.student.bean.request;/*
 *ClassName:LoginReq
 *Description: login request parameters
 *@Author:deanzhou
 *@Date:2024-01-03 19:09
 */

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginReq {

    /*
     * username    @NotBlank 校验不为空
     * */
    @NotBlank
    @TableField("user_name")
    private String username;
    /*
     * password
     * */
    @NotBlank
    private String pwd;

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
