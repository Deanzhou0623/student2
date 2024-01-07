package com.roadjava.student.exception;/*
 *ClassName:BizException
 *Description: define biz exception
 *@Author:deanzhou
 *@Date:2024-01-06 21:54
 */

import com.roadjava.student.bean.enums.CodeEnum;
import lombok.Data;

@Data
public class BizException extends RuntimeException {
    private Integer code;
    public BizException(String msg){
        super(msg);
    }

    public BizException(CodeEnum codeEnum){
        super(codeEnum.getMsg());
        this.code=codeEnum.getCode();
    }
}
