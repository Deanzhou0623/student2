package com.roadjava.student.service.impl;/*
 *ClassName:ManagerServiceImpl
 *Description: implements the functions from ManagerService interface
 *@Author:deanzhou
 *@Date:2024-01-03 19:04

 */

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.roadjava.student.bean.entity.ManagerDO;
import com.roadjava.student.mapper.ManagerMapper;
import com.roadjava.student.request.LoginReq;
import com.roadjava.student.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
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
    public String login(LoginReq loginReq) {
         //1. if the user is not exist (mybatis-plus 该对象是否存在)
        LambdaQueryWrapper<ManagerDO> lqw = new LambdaQueryWrapper<>();
        //1.1 登入请求用户名是否等于manager的用户名
        lqw.eq(ManagerDO::getUsername,loginReq.getUsername())
                .eq(ManagerDO::getPwd,loginReq.getPwd());
        //2. query user by username && password
        ManagerDO managerDO = managerMapper.selectOne(lqw);
        //3. return the info to front_end (print to log)
        log.info("result:{}", JSON.toJSONString(managerDO));
        return null;
    }
}
