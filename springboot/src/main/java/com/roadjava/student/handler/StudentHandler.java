package com.roadjava.student.handler;/*
 *ClassName:StudentHandler
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-28 23:00
 */

import com.roadjava.student.bean.request.CommonSearchReq;
import com.roadjava.student.bean.request.StudentUpdateReq;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.request.StudentAddReq;
import com.roadjava.student.bean.vo.StudentVO;
import com.roadjava.student.service.StudentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentHandler {

    @Resource
    private StudentService studentService;

    /*
    * selectByPages
    * */
    @PostMapping("/selectByPage")
    public Result<List<StudentVO>> selectByPage(@RequestBody CommonSearchReq searchReq){
        return  studentService.selectByPage(searchReq);
    }
    /*
    * add
    * */
    @PostMapping("/add")
    public Result<String> add(@RequestBody @Validated StudentAddReq studentAddReq){
        studentService.add(studentAddReq);
        return Result.buildSuccess("添加成功");
    }
    /*
    * delete
    * */
    @DeleteMapping("/deleteById")
    public Result<String> deleteById(Long id){
        //1. 判断
        if (id ==null){
            return Result.buildFailure("id 不能为空");
        }
        studentService.deleteById(id);
        return Result.buildSuccess("删除成功");
    }

    /*
    * 根据id查询student
    * */
    @GetMapping("/selectById")
    public Result<StudentVO> selectById(Long id){
        //1. 判断
        if (id ==null){
            return Result.buildFailure("id 不能为空");
        }
        //2. return student
        return  studentService.selectById(id);
    }


    /*
     * update
     * */
    @PostMapping("/updateById")
    public Result<String> updateById(@RequestBody @Validated StudentUpdateReq updateReq){
        studentService.updateById(updateReq);
        return Result.buildSuccess("add success");
    }
}
