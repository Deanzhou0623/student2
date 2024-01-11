package com.roadjava.student.service.impl;/*
 *ClassName:ScoreServiceImpl
 *Description: TODO
 *@Author:deanzhou
 *@Date:2024-01-07 20:04
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.roadjava.student.bean.entity.ScoreDO;
import com.roadjava.student.bean.entity.StudentDO;
import com.roadjava.student.bean.request.*;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.ScoreVO;
import com.roadjava.student.bean.vo.StudentVO;
import com.roadjava.student.exception.BizException;
import com.roadjava.student.mapper.ScoreMapper;
import com.roadjava.student.mapper.StudentMapper;
import com.roadjava.student.service.ScoreService;
import com.roadjava.student.service.StudentService;
import com.roadjava.student.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ScoreServiceImpl implements ScoreService {

    @Resource
    private ScoreMapper scoreMapper;

    /*
    * add student
    * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(ScoreAddReq addReq) {
        ScoreDO entity = new ScoreDO();
        BeanUtils.copyProperties(addReq,entity);
        scoreMapper.insert(entity);

    }

    /*
    * select By page
    * */
    @Override
    public Result<List<ScoreVO>> selectByPage(CommonSearchReq addReq) {
        PageUtil.startPage(addReq.getPageNow(), addReq.getPageSize());
        List<ScoreVO> list = scoreMapper.queryList(addReq);
        return PageUtil.wrapPageData(list);
    }

    /*
    * select By id
    * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        scoreMapper.deleteById(id);
    }

    /*
    * search by id
    * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<ScoreVO> selectById(Long id) {
        ScoreDO scoreDO = scoreMapper.selectById(id);
        if (scoreDO==null){
            return Result.buildEmptySuccess();
        }
        ScoreVO scoreVO = new ScoreVO();
        BeanUtils.copyProperties(scoreDO,scoreVO);
        return Result.buildSuccess(scoreVO);
    }

    /*
    * update by id
    * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(ScoreUpdateReq updateReq) {
        ScoreDO scoreDO = new ScoreDO();
        BeanUtils.copyProperties(updateReq,scoreDO);
        scoreMapper.updateById(scoreDO);
    }


}
