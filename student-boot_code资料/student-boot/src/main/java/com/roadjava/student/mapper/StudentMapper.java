package com.roadjava.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roadjava.student.bean.entity.StudentDO;
import com.roadjava.student.bean.req.CommonSearchReq;
import com.roadjava.student.bean.vo.StudentVO;

import java.util.List;


public interface StudentMapper extends BaseMapper<StudentDO> {
    List<StudentVO> queryList(CommonSearchReq searchReq);
}
