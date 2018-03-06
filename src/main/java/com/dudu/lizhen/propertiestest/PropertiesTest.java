package com.dudu.lizhen.propertiestest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2018/2/26.
 */
public class PropertiesTest {
    public static void main(String[] args) {
        PropertiesTest propertiesTest = new PropertiesTest();
        propertiesTest.ss();
        InputStream insss = PropertiesTest.class.getResourceAsStream("/zfbinfo.properties");
        Properties pss = new Properties();
        try {
            pss.load(insss);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pss.getProperty("appid"));
    }

    public void ss() {
        String proFileName = "/zfbinfo.properties";//正确的
        Properties pro;


        try {
            pro = new Properties();
            InputStream in = ClassLoader.class.getResourceAsStream(proFileName);
            pro.load(in);
            String value = pro.getProperty("appid");
            System.out.println(value);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
