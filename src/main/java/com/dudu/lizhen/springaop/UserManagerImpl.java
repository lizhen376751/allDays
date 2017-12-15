package com.dudu.lizhen.springaop;

/**
 * Created by Administrator on 2017/12/13.
 */
public class UserManagerImpl implements UserManager {

    public String findUserById(int userId) {
        System.out.println("---------UserManagerImpl.findUserById()--------");
        if (userId <= 0) {
            throw new IllegalArgumentException("该用户不存在!");
        }
        return "张三";
    }
}
