package com.roadjava.student.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 更新成绩请求
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
public class ScoreUpdateReq {
    @NotNull(message = "id必须指定")
    private Long id;
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
}

