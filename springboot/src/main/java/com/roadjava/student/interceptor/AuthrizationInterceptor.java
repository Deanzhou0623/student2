package com.roadjava.student.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.roadjava.student.bean.constants.Constants;
import com.roadjava.student.bean.dto.JwtManagerDTO;
import com.roadjava.student.bean.enums.CodeEnum;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.context.ManagerContext;
import com.roadjava.student.util.JwtUtil;
import com.roadjava.student.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Slf4j
public class AuthrizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // /student/selectById
        log.info("请求路径:{}",request.getServletPath());
        /*
         * axios对非简单的请求(比如:Content-Type:application/json)有时会
         * 通过options请求来判断服务端是否支持跨域
         */
        String method = request.getMethod();
        if (HttpMethod.OPTIONS.matches(method)) {
            // 去执行剩余的filter
            return true;
        }
        // 获取token
        String tokenToVerify = StringUtils.firstNonBlank(request.getHeader(HttpHeaders.AUTHORIZATION),request.getParameter(Constants.USER_TOKEN_KEY));
        if (StringUtils.isBlank(tokenToVerify)) {
            // 响应失败
            ResponseUtil.respAppJson(response,Result.buildFailure(CodeEnum.AUTH_ERR));
            return false;
        }
        // 校验token
        Result<DecodedJWT> verifyResult = JwtUtil.verify(tokenToVerify);
        if (verifyResult.isFailed()) {
            // 响应失败
            ResponseUtil.respAppJson(response,Result.buildFailure(CodeEnum.AUTH_ERR));
            return false;
        }
        // 从token中还原出放入的对象
        JwtManagerDTO jwtManagerDTO = JwtUtil.parse(verifyResult.getData(),JwtManagerDTO.class);
        if (jwtManagerDTO == null) {
            // 响应失败
            ResponseUtil.respAppJson(response,Result.buildFailure(CodeEnum.AUTH_ERR));
            return false;
        }
        // 放入threadlocal之后呢在任意的层(handler/service....)
        ManagerContext.set(jwtManagerDTO);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ManagerContext.remove();
    }
}
