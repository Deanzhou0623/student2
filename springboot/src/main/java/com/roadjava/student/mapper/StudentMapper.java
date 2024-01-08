package com.roadjava.student.mapper;/*
 *ClassName:StudentMapper
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-28 22:36
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roadjava.student.bean.entity.StudentDO;
import com.roadjava.student.bean.request.CommonSearchReq;
import com.roadjava.student.bean.vo.StudentVO;

import java.util.List;

public interface StudentMapper extends BaseMapper<StudentDO> {


    /*
    * search student by pages
    * */
    List<StudentVO> queryList(CommonSearchReq searchReq);
}
