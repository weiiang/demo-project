package com.demo.rabbitmq.work;

import com.demo.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName WorkModelSend
 * @Description work模型,可用来解决消息堆积的问题(生产者生产的速度远远大于消费者的速度)
 *  消费消息的时候需要经过大量的逻辑处理或者需要调用第三方的接口来处理消息,总而言之,就是消费方消费的时间远远大于生产者生产的时间
 *  该模型主要是一个生产者生产的消息给多个消费者消费
 *  在多个消费者的时候,生产者生产的消息是一次平均分配给每个消费者的:这样又会引发一个问题,那就是当每个消费者处理消息的能力不一致的时候,
 *  会造成能力强的消费者消费完成自己的消息后,会在等待,能力弱的还在继续处理消息
 *  这种情况的解决方式是;设置分配消息的方式,每一次只分配一条消息给每一个消费者,当一个消费者处理完之后继续给他分配消息,这样下来,处理能力强的消费者获取消息的次数就大于能力弱的消费者
 * @Author wq
 * @Date 2019/1/15 13:46
 * @Version 1.0.0
 */
public class WorkModelSend {
    private static Connection connection = ConnectionUtils.getInstance("127.0.0.1", "/leyou","leyou", "leyou", 5672);

    private static Logger logger = LoggerFactory.getLogger(WorkModelSend.class);

    public static void sendMsg(String queueName) throws IOException, TimeoutException {
        //从连接中创建通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(queueName, false, false, false, null);
        for (int i = 1; i< 501; i++){
            String message = "消息"+i;
            channel.basicPublish("", queueName, false, null, message.getBytes());
            logger.info("发送消息:"+message);
        }
        channel.close();
        connection.close();
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        sendMsg("testWorkQueue");
    }
}
