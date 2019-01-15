package rabbitmq.pubsub.fanout;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rabbitmq.utils.ConnectionUtils;

import java.io.IOException;

/**
 * @ClassName FanoutReceive
 * @Description TODO
 * @Author wq
 * @Date 2019/1/15 17:24
 * @Version 1.0.0
 */
public class FanoutReceive {

    private static Connection connection = ConnectionUtils.getInstance("127.0.0.1", "/leyou", "leyou", "leyou", 5672);


    private static Logger logger = LoggerFactory.getLogger(FanoutReceive.class);

    public static void receive() throws IOException {

        //从连接中获取通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare("receive1", false, false, false, null);

        // 绑定队列到交换机
        channel.queueBind("receive1", "fanoutQueue", "");

        //定义消费者
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                logger.info("receive1:"+new String(body));
            }
        };

        channel.basicConsume("receive1", true, consumer);

    }

    public static void main(String[] args) throws IOException {
        receive();
    }
}
