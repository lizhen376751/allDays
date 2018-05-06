package com.dudu.lizhen.jwttest;

import org.springframework.web.bind.annotation.*;

/**
 * 控制层代码测试
 * Created by lizhen on 2018/5/6.
 * 使用token解析流程
 * 1.客户端第一次使用用户名和密码进行登陆
 * 2.校验用户名和密码是否正确，如果正确使用jwt生成token
 * 3.将生成的token返回给客户端
 * 4.调用相关接口时在http请求上带上token的相关信息
 * 5.校验token和用户信息执行业务操作
 * 6.返回响应结果给客户端
 */
@RestController
//允许跨域访问
@CrossOrigin(origins = "http://www.lizhen.com")
public class JwtTokenControllerTest {

    /**
     * jwt封装工具类
     */
    private static JwtTokenProvider jwtTokenProvider = new JwtTokenProvider("12345678");

    /**
     * 校验用户名和密码同时生成token，并将token返回
     */
    @RequestMapping("getToken")
    @ResponseBody
    public Object getToken(String userName, String password) {
        //TODO 调用相关接口校验用户名和密码
        UserClaims userClaims = new UserClaims();
        userClaims.setUserName(userName);
        userClaims.setEmail(password);
        String token = jwtTokenProvider.createToken(userClaims);
        return token;
    }

    //TODO 也可以做一下刷新token的方法

    /**
     * 获取用户相关的数据
     *
     * @param token
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping("listData")
    public Object list(String token) {
        try {
            //验证token的正确性
            jwtTokenProvider.parseToken(token);
            //TODO 调用相关的接口或者service进行数据的查询
            //TODO xxService.doSomething（）
            return "you can!" + System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
            return "error:" + e.getMessage();
        }
    }

}
