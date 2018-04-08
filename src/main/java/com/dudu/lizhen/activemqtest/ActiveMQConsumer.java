package com.dudu.lizhen.activemqtest;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ActiveMQ 消费者
 * Created by lizhen on 2018/4/3 0003.
 */
public class ActiveMQConsumer {
    public static void main(String[] args) throws JMSException {
        //获取MQ的连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory
                (ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://127.0.0.1:61616");
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建回话工厂，第一个参数表示：是否事物提交，第二参数表示：自动签收
        //Boolean.FALSE：关闭事物提交，Boolean.TRUE：开启事物提交
        // Session.AUTO_ACKNOWLEDGE自动签收，Session.CLIENT_ACKNOWLEDGE:手动签收
        Session session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
        //创建队列
        Queue lizhen_queue = session.createQueue("lizhen_queue");
        //创建消费者
        MessageConsumer consumer = session.createConsumer(lizhen_queue);
        //持续监听消息
        while (true) {
            TextMessage textMessage = (TextMessage) consumer.receive();
            String text = textMessage.getText();
            if(null!=text){
                System.out.println("获取到的消息为：" + text);
                //表示手动签收消息了
                textMessage.acknowledge();
                //提交事物
                session.commit();
            }else{
                break;
            }

        }

    }
}
