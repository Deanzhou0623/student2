package com.roadjava.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roadjava.student.bean.entity.ScoreDO;
import com.roadjava.student.bean.entity.StudentDO;
import com.roadjava.student.bean.req.CommonSearchReq;
import com.roadjava.student.bean.vo.ScoreVO;
import com.roadjava.student.bean.vo.StudentVO;

import java.util.List;


public interface ScoreMapper extends BaseMapper<ScoreDO> {
    List<ScoreVO> queryList(CommonSearchReq searchReq);
}
