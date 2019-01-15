package com.demo.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName SendMessageUtils
 * @Description TODO
 * @Author wq
 * @Date 2019/1/15 10:42
 * @Version 1.0.0
 */
public class SendMessageUtils {

    private static Logger logger = LoggerFactory.getLogger(SendMessageUtils.class);

    private static Connection connection = ConnectionUtils.getInstance("127.0.0.1", "/leyou", "leyou", "leyou", 5672);

    public static void send(String msg, String queName) throws IOException, TimeoutException {

        //从连接中创建通道
        Channel channel = null;
        try {
            channel = connection.createChannel();
        } catch (IOException e) {
            logger.error("创建通道是失败!IO错误");
            e.printStackTrace();
        }
        // 声明（创建）队列，必须声明队列才能够发送消息，我们可以把消息发送到队列中。
        // 声明一个队列是幂等的 - 只有当它不存在时才会被创建
        try {
            channel.queueDeclare(queName, false, false, false, null);
        } catch (IOException e) {
            logger.error("队列创建失败!");
            e.printStackTrace();
        }

        try {
            channel.basicPublish("", queName, null, msg.getBytes() );
            logger.info(queName+" [send]:"+msg);
        } catch (IOException e) {
            logger.error("消息发送失败!");
            e.printStackTrace();
        }

        channel.close();
        connection.close();
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        send("Hello World! qqq", "testQueue");
    }



}
