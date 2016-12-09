package sys.amq.consumer;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * author: zf
 * Date: 2016/12/6  13:52
 * Description:队列式消息接收者
 */
@Component
public class QueueConsumer3 implements MessageListener{

    @Autowired
    private ActiveMQConnectionFactory connectionFactory;
    @Value("${Listen_Name_1}")
    private String subject;

    private Connection connection = null;

    private Session session = null;

    private MessageConsumer consumer = null;

    // 初始化
    private void initialize() throws JMSException, Exception {
        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(subject);
        consumer = session.createConsumer(queue);
    }

    // 消费消息
    public void consumeMessage() throws JMSException, Exception {
        initialize();
        connection.start();
        System.out.println("Consumer:->Begin listening...");
        // 开始监听
        consumer.setMessageListener(this);
        // Message message = consumer.receive();
    }

    // 关闭连接
    public void close() throws JMSException {
        System.out.println("Consumer:->Closing connection");
        if (consumer != null)
            consumer.close();
        if (session != null)
            session.close();
        if (connection != null)
            connection.close();
    }

    // 消息处理函数
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage txtMsg = (TextMessage) message;
                String msg = txtMsg.getText();
                System.out.println("Consumer:->Received: " + msg);
            } else {
                System.out.println("Consumer:->Received: " + message);
            }
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
