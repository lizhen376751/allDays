package com.dudu.lizhen.Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * json格式的工具类
 * Created by lizhen on 2017/8/14.
 */

public class JSONUtil {
    /**
     * 将json类型转换为实体类的类型  JSONUtil相当于一个实体类
     */
    public void setEvaluateSe() {
        String aa = "{\"evaluateMain\":{\"shopStarlevel\":\"FIVE\",\"wxPingZheng\":\"KX20170626001\",\"platenumber\":\"鲁A2032\",\"shopCode\":\"0533001\",\"shopIdentification\":\"SHOPCODE\"},\"evaluateBill\":{\"OrderType\":\"730\",\"CreateDate\":\"2017-06-26 00:00:00.0\"},\"evaluateCommodities\":[{\"serviceStaff\":\"\",\"commodityCode\":\"0010020004\",\"comIdentifica\":\"COMMODITY\",\"commodityStarlevel\":\"ONE\",\"commodityContent\":\"\",\"evaluateImgs\":[{\"orderCode\":\"\",\"mxId\":\"1\"},{\"orderCode\":\"\",\"mxId\":\"2\"},{\"orderCode\":\"\",\"mxId\":\"3\"}]},{\"serviceStaff\":\"\",\"commodityCode\":\"0010010005\",\"comIdentifica\":\"PROJECT\",\"commodityStarlevel\":\"TWO\",\"commodityContent\":\"\",\"evaluateImgs\":[{\"orderCode\":\"\",\"mxId\":\"1\"},{\"orderCode\":\"\",\"mxId\":\"2\"},{\"orderCode\":\"\",\"mxId\":\"3\"}]},{\"serviceStaff\":\"\",\"commodityCode\":\"0040010007\",\"comIdentifica\":\"PROJECT\",\"commodityStarlevel\":\"THRER\",\"commodityContent\":\"\",\"evaluateImgs\":[{\"orderCode\":\"\",\"mxId\":\"1\"},{\"orderCode\":\"\",\"mxId\":\"2\"},{\"orderCode\":\"\",\"mxId\":\"3\"}]},{\"serviceStaff\":\"\",\"commodityCode\":\"KTXM0001000100010002\",\"comIdentifica\":\"COMMODITY\",\"commodityStarlevel\":\"FOUR\",\"commodityContent\":\"\",\"evaluateImgs\":[{\"orderCode\":\"\",\"mxId\":\"1\"},{\"orderCode\":\"\",\"mxId\":\"2\"},{\"orderCode\":\"\",\"mxId\":\"3\"}]}]}";
        JSONObject jsonObject = JSONObject.parseObject(aa);
        JSONUtil evaluateReturn = JSONObject.toJavaObject(jsonObject, JSONUtil.class);
        /**
         * TODO 后面的这句话从实体类里面获取相应的参数
         */
//        List<JSONUtil> evaluateCommodities1 = evaluateReturn.getEvaluateCommodities();

        //TODO 将实体类转换成json类型 以下的方法可行
//        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(messageEntry); //将实体类传入
//        MessageEntry evaluateReturn = JSONObject.toJavaObject(jsonObject, MessageEntry.class);
//        System.out.println("========="+evaluateReturn);
    }

    /**
     * map转json,list转换成json,json转换成list
     * @throws Exception
     */
    public void addEvaluateMain() {
        List<String> list = new ArrayList<String>();
        list.add(0, "sssss");
        list.add(0, "bbbbbb");
        System.out.println("=====" + list.toString());
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", list.toString());
        //map转换成json
        Object o = JSONObject.toJSON(map);
        System.out.println("o=====" + o);
        JSONObject jsonObject = JSONObject.parseObject(o.toString());
        String string1 = jsonObject.getString("1");
        //上面这两句话相当于这句话
        String string = JSONObject.parseObject(o.toString()).getString("1");
        System.out.println("string=====" + string);

        //list转换为json
        String str = JSON.toJSON(list).toString();
        System.out.println("str=====" + str);

        //json转换为list
        list = JSONObject.parseArray(str, String.class);
        System.out.println("list======" + list);

    }
}
