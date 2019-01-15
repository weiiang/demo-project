package rabbitmq.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName ConnectionUtils
 * @Description TODO
 * @Author wq
 * @Date 2019/1/15 10:00
 * @Version 1.0.0
 */
public class ConnectionUtils {

    private static Logger logger = LoggerFactory.getLogger(ConnectionUtils.class);

    public static Connection getInstance(String host, String virtualHost, String userName, String password, int port) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        Connection connection = null;
        try {
            connection = connectionFactory.newConnection();
        } catch (IOException e) {
            logger.error("IO错误");
            e.printStackTrace();
        } catch (TimeoutException e) {
            logger.error("获取连接超时");
            e.printStackTrace();
        }
        return  connection;
    }


    public static void main(String[] args) {
        Connection instance = getInstance("127.0.0.1", "/", "leyou", "leyou", 5672);
        System.out.println(instance);
    }
}
