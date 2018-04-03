package com.dudu.lizhen.activemqtest;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * activeMq 生产者
 * Created by lizhen on 2018/4/3 0003.
 */
public class ActiveMQProdcer {
    public static void main(String[] args) throws JMSException {
        //获取MQ的连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory
                (ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://127.0.0.1:61616");
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建回话工厂
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        //创建队列
        Queue lizhen_queue = session.createQueue("lizhen_queue");
        //创建生产者
        MessageProducer producer = session.createProducer(lizhen_queue);
        //设置是否持久化，我们在这先不持久化
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        for (int i = 0; i < 10; i++) {
            sendMessage(session, producer, "我是生产者：" + i);
        }
    }

    public static void sendMessage(Session session, MessageProducer messageProducer, String i) throws JMSException {
        //创建消息
        Message message = session.createTextMessage(i);
        //发送消息
        messageProducer.send(message);
    }
}
