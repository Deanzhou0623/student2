package com.roadjava.student.bean.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
public class StudentVO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 学号
     */
    private String no;

    /**
     * 学生姓名
     */
    private String realName;
    /**
     * 入学日期
     */
    private Date enrollTime;
}
