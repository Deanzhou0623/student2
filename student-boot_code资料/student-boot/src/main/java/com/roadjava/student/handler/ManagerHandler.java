package com.roadjava.student.handler;

import com.roadjava.student.bean.req.LoginReq;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.JwtManagerVO;
import com.roadjava.student.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 管理员接口
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@RestController
@Slf4j
@RequestMapping("/manager")
public class ManagerHandler {

    @Resource
    private ManagerService managerService;

    @PostMapping("/login")
    public Result<JwtManagerVO> login(@RequestBody @Validated LoginReq loginReq) {
        log.info("login params:{}",loginReq);
        return managerService.login(loginReq);
    }

    @PostMapping("/login2")
    public Result<JwtManagerVO> login2(@Validated LoginReq loginReq) {
        log.info("login2 params:{}",loginReq);
        return managerService.login(loginReq);
    }
}
