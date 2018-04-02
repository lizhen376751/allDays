package com.dudu.lizhen.createIOC;

import com.dudu.lizhen.reflex.User;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;

/**
 * 利用dom4j+java的反射机制实现手写IOC
 * Created by lizhen on 2018/4/2 0002.
 */
public class ClassPathXmlApplicationContext {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, DocumentException, IllegalAccessException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserTest user = (UserTest)classPathXmlApplicationContext.getBean("UserTest");
        System.out.println(user.toString());
    }
    //路径
    private static String PATH;
    private static String ID;
    private static  String CLASS;
    private static  String NAME;
    private static  String VALUE;
    public void init(){
        this.ID = "id";
        this.CLASS = "class";
        this.NAME = "name";
        this.VALUE = "value";
    }

    public ClassPathXmlApplicationContext(String path) {
        init();
        this.PATH = path;
    }

    /**
     * 1.解析xml
     * 2.使用beanid查找对应的xml节点，获取class节点属性
     * 3.使用java的反射机制初始化bean
     * 4.使用java的反射机制给私有属性赋值
     * @param beanId
     * @return
     * @throws DocumentException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchFieldException
     */
    public Object getBean(String beanId) throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //1.解析xml
        if (null==beanId){
            return null;
        }
        SAXReader saxReader = new SAXReader();
        URL resource = this.getClass().getClassLoader().getResource(PATH);
        Document document = saxReader.read(resource);
        //获取根节点
        Element rootElement = document.getRootElement();
        //获取下面的子节点
        List<Element> elements = rootElement.elements();
        for (Element element:elements){
            String id = element.attributeValue("id");
            //如果获取到的节点id不等于传入进来的id，结束本次循环
            if (!id.equals(beanId)){
                continue;
            }
            //如果相等继续往下执行，获取class信息
            //从配置文件读取bean
            String classPath = element.attributeValue(CLASS);
            //利用反射初始化类
            Class<?> aClass = Class.forName(classPath);
            Object o = aClass.newInstance();
            Field[] declaredFields = aClass.getDeclaredFields();
            //获取属性值
            List<Element> elements1 = element.elements();
            for (Element elem:elements1){
                //获取配置文件的属性
                String attributeValue = elem.attributeValue(NAME);
                //获取配置文件的属性值
                String attributeValue1 = elem.attributeValue(VALUE);
                //获取类的属性
                Field declaredField = aClass.getDeclaredField(attributeValue);
                //允许设置值
                declaredField.setAccessible(true);
                //为类的属性赋值
                declaredField.set(o,attributeValue1);
            }
            return  o;
        }

        return null;
    }
}
