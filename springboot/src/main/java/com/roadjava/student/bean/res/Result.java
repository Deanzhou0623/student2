package com.roadjava.student.bean.res;/*
 *ClassName:Result
 *Description:  the result msg class
 *@Author:deanzhou
 *@Date:2024-01-05 21:28
 */

import com.roadjava.student.bean.enums.CodeEnum;
import lombok.Data;

@Data
public class Result<T> {
    /*
    * response code
    * */
    private Integer code = CodeEnum.SUCCESS.getCode();
    /*
    * response msg
    * */
    private String msg=CodeEnum.SUCCESS.getMsg();

    /*
    * 判断成功或者失败
    * true:成功
    * false:失败
    * */
    public boolean success=Boolean.TRUE;

    private T Data;

    private Long total;


    /*
    * success
    *
    * */
    public Result(){}

     public static<T> Result<T> buildEmptySuccess(){
         return new Result<>();
     }
     /*
     * return the info
     * */
    public static<T> Result<T> buildSuccess(T t){
        Result<T> result = buildEmptySuccess();
        result.setData(t);
        return result;
    }

    /*
    * return the result info and total number
    * */
    public static<T> Result<T> buildSuccess(T t,Long total){
        Result<T> result = buildSuccess(t);
        result.setTotal(total);
        return result;
    }

    /*
    * fail -msg
    * */
    public static<T> Result<T> buildFailure(String msg){
        Result<T> result = new Result<>();
        result.setCode(null);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }

    public static<T> Result<T> buildFailure(Integer code,String msg){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }

    public static<T> Result<T> buildFailure(CodeEnum codeEnum){
        Result<T> result = new Result<>();
        result.setCode(codeEnum.getCode());
        result.setMsg(codeEnum.getMsg());
        result.setSuccess(false);
        return result;
    }

    /*
    * is success
    * */
    public boolean isSuccess(){
        return success;
    }
    /*
    *  is fail
    * */
    public boolean isFailed(){
        return !isSuccess();
    }
}
