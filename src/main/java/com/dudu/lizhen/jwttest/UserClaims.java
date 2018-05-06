package com.dudu.lizhen.jwttest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.JwtMap;

import java.util.Date;

/**
 * 权限对象
 * Created by lizhen on 2018/5/6.
 */

public class UserClaims extends JwtMap implements Claims {

    private String[] scope;

    private String grantType = "password";
    /**
     * 用户名
     */
    private String userName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phone;

    public String[] getScope() {
        return scope;
    }

    public void setScope(String[] scope) {
        this.scope = scope;
        setValue("scope",this.scope);
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
        setValue("grantType",this.grantType);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        setValue("userName",this.userName);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        setValue("email",this.email);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        setValue("phone",this.phone);
    }


    @Override
    public String getIssuer() {
        return null;
    }

    @Override
    public Claims setIssuer(String s) {
        return null;
    }

    @Override
    public String getSubject() {
        return null;
    }

    @Override
    public Claims setSubject(String s) {
        return null;
    }

    @Override
    public String getAudience() {
        return null;
    }

    @Override
    public Claims setAudience(String s) {
        return null;
    }

    @Override
    public Date getExpiration() {
        return null;
    }

    @Override
    public Claims setExpiration(Date date) {
        return null;
    }

    @Override
    public Date getNotBefore() {
        return null;
    }

    @Override
    public Claims setNotBefore(Date date) {
        return null;
    }

    @Override
    public Date getIssuedAt() {
        return null;
    }

    @Override
    public Claims setIssuedAt(Date date) {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public Claims setId(String s) {
        return null;
    }

    @Override
    public <T> T get(String s, Class<T> aClass) {
        return null;
    }
}
