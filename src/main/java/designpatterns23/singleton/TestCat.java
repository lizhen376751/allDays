package designpatterns23.singleton;


import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created by Administrator on 2017/12/20.
 */
public class TestCat {
    public static void main(String[] args) {



        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://127.0.0.1/app.ZMTManage/?m=zmtmanage&c=index&a=init");
        try {
            CloseableHttpResponse execute = aDefault.execute(httpGet);
            int statusCode = execute.getStatusLine().getStatusCode();
            System.out.println(statusCode);

        } catch (IOException e) {
            e.printStackTrace();
        }

//        HashMap<String,Object> Info = new HashMap<String, Object>();
//        int ss = 56;
//        Info.put("DepartmentBm",ss);
//        String DepartmentBm = Info.get("DepartmentBm").toString();
//        System.out.println(DepartmentBm);
//        Cat cat1 = Cat.getCat();
//        cat1.setGreen("green1");
//        cat1.setRed("red1");
//        System.out.println("cat1="+cat1.toString());
//        Cat cat2 = Cat.getCat();
//        cat2.setGreen("green2");
//        cat2.setRed("red2");
//        System.out.println("cat1="+cat1.toString());
//        System.out.println("cat2="+cat2.toString());
//        Cat cat3 = Cat.cat;
//        System.out.println("cat3="+cat3.toString());
    }
}
