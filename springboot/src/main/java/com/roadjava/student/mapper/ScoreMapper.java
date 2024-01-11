package com.roadjava.student.mapper;/*
 *ClassName:ManagerMapper
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-28 22:36
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roadjava.student.bean.entity.ManagerDO;
import com.roadjava.student.bean.entity.ScoreDO;
import com.roadjava.student.bean.request.CommonSearchReq;
import com.roadjava.student.bean.vo.ScoreVO;
import com.roadjava.student.bean.vo.StudentVO;

import java.util.List;

public interface ScoreMapper extends BaseMapper<ScoreDO> {

    /*
    * select by username && id
    * */
//    ManagerDO selectUser(LambdaQueryWrapper<ManagerDO> lqw);
    List<ScoreVO> queryList(CommonSearchReq searchReq);
}
