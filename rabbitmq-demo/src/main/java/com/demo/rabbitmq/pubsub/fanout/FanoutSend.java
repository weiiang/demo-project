package com.demo.rabbitmq.pubsub.fanout;

import com.demo.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 发布订阅模型->fanout
 *
 * @ClassName FanoutSend
 * @Description TODO
 * @Author wq
 * @Date 2019/1/15 16:50
 * @Version 1.0.0
 */
public class FanoutSend {

    private static Connection connection = ConnectionUtils.getInstance("127.0.0.1", "/leyou", "leyou", "leyou", 5672);

    public static void sendMsg(String exchageName) throws IOException, TimeoutException {

        //从连接中创建通道
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(exchageName, "fanout");

        String msg = "hello!";
        //发送消息
        channel.basicPublish(exchageName, "", null, msg.getBytes());

        channel.close();
        connection.close();
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        sendMsg("fanoutQueue");
    }
}
