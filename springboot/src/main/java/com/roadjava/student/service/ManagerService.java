package com.roadjava.student.service;/*
 *ClassName:ManagerService
 *Description: functions from manager 
 *@Author:deanzhou
 *@Date:2024-01-03 19:03
 */

import com.roadjava.student.request.LoginReq;

public interface ManagerService {

    /*
    *  query user account && password
    * */
    String login(LoginReq loginReq);
}
