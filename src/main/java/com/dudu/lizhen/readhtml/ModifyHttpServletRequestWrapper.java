package com.dudu.lizhen.readhtml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

/**
 * 装饰者模式，因为httpservlertrequest没有获取参数的方法，可以用这个装饰器，来进行获取并可以往消息头里面添加参数
 * 向请求头添加数据的工具包
 */
public class ModifyHttpServletRequestWrapper extends HttpServletRequestWrapper {
 
    private Map<String, String> customHeaders;
 
    public ModifyHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.customHeaders = new HashMap();
    }
 
    public void putHeader(String name, String value) {
        this.customHeaders.put(name, value);
    }
 
    public String getHeader(String name) {
        String value = this.customHeaders.get(name);
        if (value != null) {
            return value;
        }
        return ((HttpServletRequest) getRequest()).getHeader(name);
    }
 
    public Enumeration<String> getHeaderNames() {
        Set<String> set = new HashSet(customHeaders.keySet());
        Enumeration<String> enumeration = ((HttpServletRequest) getRequest()).getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            set.add(name);
        }
        return Collections.enumeration(set);
    }
 
}