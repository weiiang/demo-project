package rabbitmq.utils;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @ClassName ReceiveMessageUtils
 * @Description TODO
 * @Author wq
 * @Date 2019/1/15 10:38
 * @Version 1.0.0
 */
public class ReceiveMessageUtils {

    private static Logger logger = LoggerFactory.getLogger(ReceiveMessageUtils.class);

    private static Connection connection = ConnectionUtils.getInstance("127.0.0.1", "/leyou", "leyou", "leyou", 5672);

    public static void receive(String queName) throws IOException {
        //创建通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(queName, false, false, false, null);
        //定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                logger.info(queName+" [receive]:"+msg);

                //手动ACK
                //channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        channel.basicConsume(queName, true, consumer);
        /**
         * 手动ACK的好处:
         * 可以在抛出异常之后不从消息队列中删除处理异常的消息
         * 而自动ACK,在消费者接收消息的回调函数发生异常的时候会清楚消息,只要消息被接收到了,就会清除消息
         */
        //channel.basicConsume(queName, false, consumer);
    }

    public static void main(String[] args) throws IOException {
        receive("testQueue");
    }
}
