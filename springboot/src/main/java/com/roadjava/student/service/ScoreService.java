package com.roadjava.student.service;/*
 *ClassName:StudentService
 *Description: TODO
 *@Author:deanzhou
 *@Date:2024-01-07 20:03
 */

import com.roadjava.student.bean.request.*;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.ScoreVO;
import com.roadjava.student.bean.vo.StudentVO;

import java.util.List;

public interface ScoreService {
    /*
    * add student
    * */
    void add(ScoreAddReq addReq);

    /*
    * select By page
    * */
    Result<List<ScoreVO>> selectByPage(CommonSearchReq addReq);

    void deleteById(Long id);

    Result<ScoreVO> selectById(Long id);

    void updateById(ScoreUpdateReq updateReq);
}
