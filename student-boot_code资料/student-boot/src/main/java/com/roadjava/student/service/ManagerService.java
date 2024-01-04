package com.roadjava.student.service;

import com.roadjava.student.bean.req.LoginReq;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.JwtManagerVO;

public interface ManagerService {
    Result<JwtManagerVO> login(LoginReq loginReq);
}
