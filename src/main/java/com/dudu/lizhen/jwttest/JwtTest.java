package com.dudu.lizhen.jwttest;

import io.jsonwebtoken.Claims;

/**
 * jwt测试用例编写
 * Created by 李振 on 2018/5/6.
 */
public class JwtTest {
    public static void main(String[] args) {
        //秘钥 12345678
        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider("1234567");
        UserClaims userClaims = new UserClaims();
        userClaims.setUserName("Tony");
        userClaims.setEmail("tony@qq.com");


        String token = jwtTokenProvider.createToken(userClaims);
        System.out.println("生成的token" + token);


        Claims claims = jwtTokenProvider.parseToken(token);
        System.out.println("解析出来的Token内容：" + claims);

    }

}
