package com.dudu.lizhen.date;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式的转换
 * Created by lizhen on 2017/11/20.
 */
public class DateFormatting implements Serializable{
    /**
     * 将日期戳转换成想要的日期格式
     * @param args
     */
    public static void main(String args[]) {
        /**
         * 日期戳转成想要的格式
         */
        String str ="1510988079090";
        Long timeLong = Long.parseLong(str);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null; //你要的日期格式
        try {
            date = sdf.parse(sdf.format(timeLong));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(sdf.format(date));

        /**
         * 数据库的日期转成想要的日期格式
         */
        try {
            Date parse = sdf.parse("2017-11-21 14:36:00.28");
            String toLocaleString = parse.toLocaleString();
            System.out.println("第二个日期:"+parse.toLocaleString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    /**
     * 日期戳转成想要的格式
     */
    public void formatStamp(){
        String str ="1510988079090"; //13的日期戳
        Long timeLong = Long.parseLong(str);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null; //你要的日期格式
        try {
            date = sdf.parse(sdf.format(timeLong));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String format = sdf.format(date);
        System.out.println(format);  //输出结果为这种格式 2017-11-18 14:54:39
    }

    /**
     * 数据库的日期转成想要的日期格式
     */
    public void StringTimeToFormat(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = sdf.parse("2017-11-21 14:36:00.28");
            String toLocaleString = parse.toLocaleString();
            System.out.println(toLocaleString); //输出结果为这种格式   2017-11-21 14:36:00
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
