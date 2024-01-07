package com.roadjava.student.service.impl;/*
 *ClassName:ManagerServiceImpl
 *Description: implements the functions from ManagerService interface
 *@Author:deanzhou
 *@Date:2024-01-03 19:04

 */

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.roadjava.student.bean.entity.ManagerDO;
import com.roadjava.student.bean.dto.JwtManagerDTO;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.JwtManagerVO;
import com.roadjava.student.mapper.ManagerMapper;
import com.roadjava.student.request.LoginReq;
import com.roadjava.student.service.ManagerService;
import com.roadjava.student.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {
    public static final LambdaQueryWrapper<ManagerDO> MANAGER_DO_LAMBDA_QUERY_WRAPPER = new LambdaQueryWrapper<>();
    @Resource
    private ManagerMapper managerMapper;

    /*
    * query users' username && password
    * */
    @Override
    public Result<JwtManagerVO> login(LoginReq loginReq) {
         //1. if the user is not exist (mybatis-plus 该对象是否存在)
        LambdaQueryWrapper<ManagerDO> lqw = new LambdaQueryWrapper<>();
        //1.1 登入请求用户名是否等于manager的用户名
        lqw.eq(ManagerDO::getUsername,loginReq.getUsername())
                .eq(ManagerDO::getPwd,loginReq.getPwd());
        //2. query user by username && password
        ManagerDO managerDO = managerMapper.selectOne(lqw);
        //3. return the info to front_end (print to log)
        log.info("result:{}", JSON.toJSONString(managerDO));
        //4. return msg if there is no manager
        if(managerDO ==null){
            return Result.buildFailure("用户名或者密码不正确");
        }
        //5. generate token
        JwtManagerVO vo = generateToken(managerDO);
        //6. print
        log.info("result:{}",vo);
        return Result.buildSuccess(vo);
    }

    /*
    * depends login info generate token
    * */
    private JwtManagerVO generateToken(ManagerDO managerDO) {
        JwtManagerDTO jwtManagerDTO = new JwtManagerDTO();
        //1. copy attributes to jwtManagerDTO
        BeanUtils.copyProperties(managerDO,jwtManagerDTO);
        String token = JwtUtil.getToken(jwtManagerDTO);
        //2. return ( token && user info)
        JwtManagerVO vo = new JwtManagerVO();
        //2.1 copy user info from jwtManagerDTO to vo
        BeanUtils.copyProperties(jwtManagerDTO,vo);
        vo.setToken(token);
        return vo;

    }
}
