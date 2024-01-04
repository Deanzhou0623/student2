package com.roadjava.student.bean.dto;

import lombok.Data;

/**
 * 定义了返回给前端的token是由哪些信息生成的
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
public class JwtManagerDTO {

    private Long id;
    /**
     * 用户名
     */
    private String userName;
}
