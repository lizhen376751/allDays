package com.dudu.lizhen.Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * json格式的工具类
 * Created by lizhen on 2017/8/14.
 */

public class JSONUtil {
    public static void main(String[] args) {
        createJson();
    }
    /**
     * 将json类型转换为实体类的类型  JSONUtil相当于一个实体类
     */
    public void setEvaluateSe() {

        String aa = "{\"evaluateMain\":{\"shopStarlevel\":\"FIVE\",\"wxPingZheng\":\"KX20170626001\",\"platenumber\":\"鲁A2032\",\"shopCode\":\"0533001\",\"shopIdentification\":\"SHOPCODE\"},\"evaluateBill\":{\"OrderType\":\"730\",\"CreateDate\":\"2017-06-26 00:00:00.0\"},\"evaluateCommodities\":[{\"serviceStaff\":\"\",\"commodityCode\":\"0010020004\",\"comIdentifica\":\"COMMODITY\",\"commodityStarlevel\":\"ONE\",\"commodityContent\":\"\",\"evaluateImgs\":[{\"orderCode\":\"\",\"mxId\":\"1\"},{\"orderCode\":\"\",\"mxId\":\"2\"},{\"orderCode\":\"\",\"mxId\":\"3\"}]},{\"serviceStaff\":\"\",\"commodityCode\":\"0010010005\",\"comIdentifica\":\"PROJECT\",\"commodityStarlevel\":\"TWO\",\"commodityContent\":\"\",\"evaluateImgs\":[{\"orderCode\":\"\",\"mxId\":\"1\"},{\"orderCode\":\"\",\"mxId\":\"2\"},{\"orderCode\":\"\",\"mxId\":\"3\"}]},{\"serviceStaff\":\"\",\"commodityCode\":\"0040010007\",\"comIdentifica\":\"PROJECT\",\"commodityStarlevel\":\"THRER\",\"commodityContent\":\"\",\"evaluateImgs\":[{\"orderCode\":\"\",\"mxId\":\"1\"},{\"orderCode\":\"\",\"mxId\":\"2\"},{\"orderCode\":\"\",\"mxId\":\"3\"}]},{\"serviceStaff\":\"\",\"commodityCode\":\"KTXM0001000100010002\",\"comIdentifica\":\"COMMODITY\",\"commodityStarlevel\":\"FOUR\",\"commodityContent\":\"\",\"evaluateImgs\":[{\"orderCode\":\"\",\"mxId\":\"1\"},{\"orderCode\":\"\",\"mxId\":\"2\"},{\"orderCode\":\"\",\"mxId\":\"3\"}]}]}";
        JSONObject jsonObject = JSONObject.parseObject(aa);
        //json获取里面的字符串，直接就是字符串。
        String evaluateMain = jsonObject.getString("evaluateMain");
        //json获取集合
        JSONArray shopStarlevel = jsonObject.getJSONArray("shopStarlevel");
        //json转化对象，第一个参数json字符串，第二个参数需要转换的实体类
        JSONUtil evaluateReturn = JSONObject.toJavaObject(jsonObject, JSONUtil.class);
        /**
         * TODO 后面的这句话从实体类里面获取相应的参数
         */
//        List<JSONUtil> evaluateCommodities1 = evaluateReturn.getEvaluateCommodities();

        //TODO 将实体类转换成json类型，然后将实体类转换成json 以下的方法可行
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

    /**
     * 自定义json，按照属性或者集合，组装json
     */
    public static void createJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("lizhen1","12000");
        jsonObject.put("lizhen2","12000");
        jsonObject.put("lizhen3","12000");
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("lizhen11","12000");
        jsonObject1.put("lizhen12","12000");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("lizhen21","12000");
        jsonObject2.put("lizhen22","12000");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        jsonObject.put("lizhen4",jsonArray);
        String toString = jsonObject.toString();
        System.out.println(toString);
    }
}
