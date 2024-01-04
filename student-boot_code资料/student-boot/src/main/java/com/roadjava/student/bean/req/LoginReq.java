package com.roadjava.student.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录请求参数
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
public class LoginReq {
    /**
     * 用户名
     */
    @NotBlank
    private String userName;
    /**
     * 密码
     */
    @NotBlank
    private String pwd;
}
