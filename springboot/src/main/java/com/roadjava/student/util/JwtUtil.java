package com.roadjava.student.util;/*
 *ClassName:JwtUtil
 *Description: 
 *@Author:deanzhou
 *@Date:2024-01-03 22:55
 */

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.roadjava.student.bean.res.Result;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;

@Data
@Slf4j
public class JwtUtil {

    /*
    * define secret
    * */
    private static final String SECRET="roadjava.com";

    /**
    *@MethodName: getToken
    *@Description generate token
    *@Auther DeanZhou
    *@Date 2024-01-03 23:08
    **/
    public static <T> String getToken(T t){
        //1. define the expiration
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MONTH,2);
        //2. add claims: id = xxx ,name = xxxx
        JWTCreator.Builder builder = JWT.create().
                withClaim(t.getClass().getSimpleName(), JSON.toJSONString(t));
        //3.generate token  && add signature
        String token = builder.withExpiresAt(expiration.getTime())
                .sign(Algorithm.HMAC256(SECRET));

        //4. return token
        return token;
    }

    /**
     * 用来校验token是否合法
     */
    public static Result<DecodedJWT> verify(String tokenToVerify) {
        String errMsg;
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET))
                    .build().verify(tokenToVerify);
            return Result.buildSuccess(decodedJWT);
        }catch (AlgorithmMismatchException e) {
            errMsg = "算法不匹配";
            log.error(errMsg,e);
        }catch (SignatureVerificationException e) {
            errMsg = "签名不匹配";
            log.error(errMsg,e);
        }catch (TokenExpiredException e) {
            errMsg = "令牌失效";
            log.error(errMsg,e);
        }catch (InvalidClaimException e) {
            errMsg = "声明无效";
            log.error(errMsg,e);
        }catch (Exception e) {
            errMsg = "校验令牌失败";
            log.error(errMsg,e);
        }
        return Result.buildFailure(errMsg);
    }

    public static <T> T parse(DecodedJWT decodedJWT, Class<T> clz) {
        // 与放入时声明的名字一致
        Claim claim = decodedJWT.getClaim(clz.getSimpleName());
        if (claim == null) {
            return null;
        }
        return JSON.parseObject(claim.asString(),clz);
    }
}
