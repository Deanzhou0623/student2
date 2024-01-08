package com.roadjava.student.service;/*
 *ClassName:StudentService
 *Description: TODO
 *@Author:deanzhou
 *@Date:2024-01-07 20:03
 */

import com.roadjava.student.bean.request.CommonSearchReq;
import com.roadjava.student.bean.request.StudentAddReq;
import com.roadjava.student.bean.request.StudentUpdateReq;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.StudentVO;

import java.util.List;

public interface StudentService {
    /*
    * add student
    * */
    void add(StudentAddReq studentAddReq);

    /*
    * search student by pages 
    * */
    Result<List<StudentVO>> selectByPage(CommonSearchReq searchReq);

    /*
    * delete by id
    * */
    void deleteById(Long id);

    /*
    * search student by id
    * */
    Result<StudentVO> selectById(Long id);

    /*
    * update by id
    * */
    void updateById(StudentUpdateReq updateReq);
}
