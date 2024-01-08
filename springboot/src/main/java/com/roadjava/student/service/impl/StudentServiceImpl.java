package com.roadjava.student.service.impl;/*
 *ClassName:StudentServiceImpl
 *Description: TODO
 *@Author:deanzhou
 *@Date:2024-01-07 20:04
 */

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.roadjava.student.bean.entity.StudentDO;
import com.roadjava.student.bean.request.CommonSearchReq;
import com.roadjava.student.bean.request.StudentAddReq;
import com.roadjava.student.bean.request.StudentUpdateReq;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.StudentVO;
import com.roadjava.student.exception.BizException;
import com.roadjava.student.mapper.StudentMapper;
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
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    /*
    * add student
    * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(StudentAddReq studentAddReq) {
        //1. check student number before add
        LambdaQueryWrapper<StudentDO> qw = new LambdaQueryWrapper<>();
        qw.eq(StudentDO::getNo,studentAddReq.getNo());
        Long count = studentMapper.selectCount(qw);
        //1.1 if count >1 , student added repeatedly !
        if (count>0){
            //1.2 throw bizException
            throw new BizException("学号已存在！");
        }
        //2. add to database
        StudentDO studentDO = new StudentDO();
        BeanUtils.copyProperties(studentAddReq,studentDO);
        studentMapper.insert(studentDO);
    }

    /*
    * search students by pages
    * */
    @Override
    public Result<List<StudentVO>> selectByPage(CommonSearchReq searchReq) {
        PageUtil.startPage(searchReq.getPageNow(),searchReq.getPageSize());
        List<StudentVO> list=studentMapper.queryList(searchReq);
        return PageUtil.wrapPageData(list);
    }

    /*
    * delete by id
    * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        studentMapper.deleteById(id);
    }

    /*
    * search by student id
    * */
    @Override
    public Result<StudentVO> selectById(Long id) {
        //1. search by id
        StudentDO studentDO = studentMapper.selectById(id);
        // if there is no student
        if (studentDO==null) {
            /*
            * 成功查询，但是无结果
            * */
            return Result.buildEmptySuccess();
        }
        StudentVO vo = new StudentVO();
        BeanUtils.copyProperties(studentDO,vo);
        return Result.buildSuccess(vo);
    }


    /*
    * update by id
    * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(StudentUpdateReq updateReq) {
        StudentDO studentDO = new StudentDO();
        BeanUtils.copyProperties(updateReq,studentDO);
        studentMapper.updateById(studentDO);
    }
}
