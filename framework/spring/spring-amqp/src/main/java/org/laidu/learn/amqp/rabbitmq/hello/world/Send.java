package org.laidu.learn.amqp.rabbitmq.hello.world;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * send
 * <p>
 * Created by 臧天才 on 2017-09-13 13:38.
 */

// TODO : 2017-09-13 13:38  send
@Slf4j
public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setPort(5672);
        factory.setVirtualHost("/hello");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "Hello World!";

//        while (true){
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
//        }

        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();


    }
}
