package org.laidu.learn.amqp.rabbitmq.official.rpc.custom;


import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

/**
 * rabbitmq 官方示例 RpcClient
 * <p>
 *
 * @author 臧天才
 * @date 2017-09-13 11:02
 */
@Slf4j
public class RpcClient {

    private Connection connection;
    private Channel channel;
    private String replyQueueName;

    public RpcClient() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("local-dev");
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setPort(5672);
        factory.setVirtualHost("/rpc");

        connection = factory.newConnection();
        channel = connection.createChannel();

        String replyTo = "rpc_reply_to";
        replyQueueName = channel.queueDeclare(replyTo,true,false,false,null).getQueue();
//        replyQueueName = channel.queueDeclare().getQueue();
    }

    public String call(String message) throws IOException, InterruptedException {
        String corrId = UUID.randomUUID().toString();

        AMQP.BasicProperties props = new AMQP.BasicProperties
                .Builder()
                .correlationId(corrId)
                .replyTo(replyQueueName)
                .build();

        channel.basicPublish("", RpcServer.RPC_QUEUE_NAME, props, message.getBytes("UTF-8"));

        final BlockingQueue<String> response = new ArrayBlockingQueue<>(1);

        channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                if (properties.getCorrelationId().equals(corrId)) {
                    response.offer(new String(body, "UTF-8"));
                }
            }
        });

        return response.take();
    }

    public void close() throws IOException {
        connection.close();
    }

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        RpcClient fibonacciRpc = new RpcClient();

//        ExecutorService service  = Executors.newFixedThreadPool(10);
//        service.submit(()->{
//
//            System.out.println(" [x] Requesting fib(30)");
//            String response = null;
//            try {
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println(" [.] Got '" + response + "'");
//        });

        String result = fibonacciRpc.call("30");

        fibonacciRpc.close();

        System.out.println(result);

    }

}
