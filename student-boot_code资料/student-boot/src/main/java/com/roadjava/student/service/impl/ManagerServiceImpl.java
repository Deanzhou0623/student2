package com.roadjava.student.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.roadjava.student.bean.dto.JwtManagerDTO;
import com.roadjava.student.bean.entity.ManagerDO;
import com.roadjava.student.bean.req.LoginReq;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.JwtManagerVO;
import com.roadjava.student.mapper.ManagerMapper;
import com.roadjava.student.service.ManagerService;
import com.roadjava.student.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;


    @Override
    public Result<JwtManagerVO> login(LoginReq loginReq) {
        // 查询用户是否存在
        LambdaQueryWrapper<ManagerDO> qw = new LambdaQueryWrapper<>();
        qw.eq(ManagerDO::getUserName,loginReq.getUserName())
                .eq(ManagerDO::getPwd,loginReq.getPwd());
        ManagerDO managerDO = managerMapper.selectOne(qw);
        if (managerDO == null) {
            return Result.buildFailure("用户名或密码不正确");
        }
        JwtManagerVO vo = generateToken(managerDO);
        return Result.buildSuccess(vo);
    }

    private JwtManagerVO generateToken(ManagerDO managerDO) {
        JwtManagerDTO jwtManagerDTO = new JwtManagerDTO();
        BeanUtils.copyProperties(managerDO,jwtManagerDTO);
        String token = JwtUtil.getToken(jwtManagerDTO);
        // 返回给前端 token + 用户信息
        JwtManagerVO vo = new JwtManagerVO();
        BeanUtils.copyProperties(jwtManagerDTO,vo);
        vo.setToken(token);
        return vo;
    }
}
