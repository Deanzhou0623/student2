package com.roadjava.student.handler;/*
 *ClassName:ManagerHandler
 *Description: manager controller 
 *@Author:deanzhou
 *@Date:2023-12-28 23:00
 */

import com.roadjava.student.request.LoginReq;
import com.roadjava.student.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manager")
public class ManagerHandler {

    @Resource
    private ManagerService managerService;

    @PostMapping("/login")
    public String login(@RequestBody  LoginReq loginReq){
        return managerService.login(loginReq);
    }
}
