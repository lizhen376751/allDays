package com.dudu.lizhen.propertiestest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件
 * 并且解决中文乱码问题
 * Created by lizhen on 2018/2/26.
 */
public class PropertiesTest {
    public static void main(String[] args) {
        getValue("appid");
    }

    public static String getValue(String name) {
        String proFileName = "/zfbinfo.properties";//正确的
        Properties pro;
        String value = "";
        InputStream in = null;
        try {
            pro = new Properties();
            in = ClassLoader.class.getResourceAsStream(proFileName);
            pro.load(in);
            value = new String(pro.getProperty(name).getBytes("ISO-8859-1"), "UTF-8");
            System.out.println(value);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
