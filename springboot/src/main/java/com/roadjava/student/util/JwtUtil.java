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

import java.util.Calendar;

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
}
