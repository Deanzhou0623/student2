package com.roadjava.student.handler;/*
 *ClassName:ScoreHandler
 *Description: score controller
 *@Author:deanzhou
 *@Date:2023-12-28 23:00
 */

import com.roadjava.student.bean.entity.ScoreDO;
import com.roadjava.student.bean.request.*;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.ScoreVO;
import com.roadjava.student.bean.vo.StudentVO;
import com.roadjava.student.service.ScoreService;
import com.roadjava.student.service.StudentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreHandler {

    @Resource
    private ScoreService scoreService;

    /*
    * add
    * */
    @PostMapping("/add")
    public Result<String> add(@RequestBody @Validated ScoreAddReq addReq){
        scoreService.add(addReq);
        return Result.buildSuccess("添加成功");
    }

    /*
    * select by page
    * */
    @PostMapping("/selectByPage")
    public Result<List<ScoreVO>> selectByPage(@RequestBody CommonSearchReq addReq){
          return scoreService.selectByPage(addReq);
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
        scoreService.deleteById(id);
        return Result.buildSuccess("删除成功");
    }

    /*
     * 根据id查询score
     * */
    @GetMapping("/selectById")
    public Result<ScoreVO> selectById(Long id){
        //1. 判断
        if (id ==null){
            return Result.buildFailure("id 不能为空");
        }
        //2. return student
        return  scoreService.selectById(id);
    }

    /*
     * update
     * */
    @PostMapping("/updateById")
    public Result<String> updateById(@RequestBody @Validated ScoreUpdateReq updateReq){
        scoreService.updateById(updateReq);
        return Result.buildSuccess("add success");
    }


}
