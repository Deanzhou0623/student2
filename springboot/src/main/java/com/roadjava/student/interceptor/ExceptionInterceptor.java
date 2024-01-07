package com.roadjava.student.interceptor;/*
 *ClassName:ExceptionInterceptor
 *Description: Unified handling of exception information
 *@Author:deanzhou
 *@Date:2024-01-05 22:21
 */

import com.roadjava.student.bean.enums.CodeEnum;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
@Slf4j
public class ExceptionInterceptor {
    /*
     * handleException: handle BindException
     * */
    @ExceptionHandler(BindException.class)
    public Result<String> handleException(BindException e){
        log.error("参数绑定异常",e);
        BindingResult bindingResult = e.getBindingResult();
        //获取用过校验字段的详情
        List<FieldError> fieldErrors =bindingResult.getFieldErrors();
        return Result.buildFailure(errorMsgSplit(fieldErrors));
    }

    /*
    * handleException: handle methodArgumentNotValueException
    * */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleException(MethodArgumentNotValidException e){
         log.error("入参校验失败",e);
        BindingResult bindingResult = e.getBindingResult();
        //获取用过校验字段的详情
        List<FieldError> fieldErrors =bindingResult.getFieldErrors();
        return Result.buildFailure(errorMsgSplit(fieldErrors));
    }

    /*
    * illegal argument Exception
    * */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result<String> handleException(IllegalArgumentException e){
        log.error("参数非法",e);
        return Result.buildFailure(CodeEnum.PARAM_ERR);
    }

    /*
     * badSqlGrammer Exception
     * */
    @ExceptionHandler(BadSqlGrammarException.class)
    public Result<String> handleException(BadSqlGrammarException e){
        log.error("sql错误",e);
        return Result.buildFailure(CodeEnum.DB_ERR);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result<String> handleEx(DuplicateKeyException e) {
        log.error("唯一性约束校验失败",e);
        return Result.buildFailure(CodeEnum.DUPLICATE_KEY_ERR);
    }

    @ExceptionHandler(BizException.class)
    public Result<String> handleEx(BizException e) {
        log.error("业务异常",e);
        return Result.buildFailure(e.getCode(),e.getMessage());
    }

    /**
     * 处理未精准匹配的异常
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleEx(Exception e) {
        log.error("处理未精准匹配的异常",e);
        return Result.buildFailure(CodeEnum.SYS_ERR);
    }
    /*
    * error msg split
    * */
    private String errorMsgSplit(List<FieldError > fieldErrors){
        return fieldErrors.stream().map(fieldError ->{
            StringBuilder sb = new StringBuilder();
            sb.append("属性:").append(fieldError.getField())
                    .append(",传入的值为:").append(fieldError.getRejectedValue())
                    .append("校验不通过的原因是:").append(fieldError.getDefaultMessage());
            return sb.toString();
        } ).collect(Collectors.joining(";"));
    }
}
