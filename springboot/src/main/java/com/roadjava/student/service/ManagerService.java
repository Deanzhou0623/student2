package com.roadjava.student.service;/*
 *ClassName:ManagerService
 *Description: functions from manager 
 *@Author:deanzhou
 *@Date:2024-01-03 19:03
 */

import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.JwtManagerVO;
import com.roadjava.student.bean.request.LoginReq;

public interface ManagerService {

    /*
    *  query user account && password
    * */
    Result<JwtManagerVO> login( LoginReq loginReq);
}
