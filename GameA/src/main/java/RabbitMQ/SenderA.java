/** Project: Systems Integration Space Game: File Files, RabbitMQ, and Web Service/JSON
 * Purpose Details: use RabbitMQ and Web Services for sending and receiving game object data between applications GameA and GameB
 * Course:IST242
 * Author:Christina Yang
 * Date Developed:Jun 8 2024
 * Last Date Changed: Jun 11 2024
 * Rev:4

 */
package RabbitMQ;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

/**
 * RabbitMQ server will declares a queue, and sends a message to that queue.
 * The SenderA send a message to the RabbitMQ queue named "SpaceGame".
 * Create a connection and set server host
 * Finds the queue named "SpaceGame"
 * message is sent to the queue
 * Print the confirmation message
 */
public class SenderA {
    private final static String QUEUE_NAME = "SpaceGame";
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "SpaceGame";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

        }
    }
}
