package com.roadjava.student.bean.enums;/*
 *ClassName:CodeEnum
 *Description: response code enum
 *@Author:deanzhou
 *@Date:2024-01-05 21:34
 */

public enum CodeEnum {
    SUCCESS(200,"success"),
    PARAM_ERR(10000,"parameter error"),

    DB_ERR(20000,"数据库异常"),
    DUPLICATE_KEY_ERR(20001,"唯一性约束校验失败"),

    BIZ_ERR(30000,"业务异常"),
    AUTH_ERR(30001,"权限不足"),

    SYS_ERR(90000,"系统异常"),
    ;
    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    //code
    private Integer code;
    
    /*
    * code info
    * */
    private String msg;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
