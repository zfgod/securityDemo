package sys.amq.producer;

import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * author: zf
 * Date: 2016/12/6  13:51
 * Description:发布/订阅式消息生成者
 */
@Component("sessionTopicProducer")
public class SessionTopicProducer {
    @Autowired
    @Qualifier("amqConnectionFactory")
    private ActiveMQConnectionFactory connectionFactory;

    /**
     * 发送一条消息到指定的队列（目标）
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void sendTopicMsg(String queueName,final String message) throws JMSException {
        Connection connection = null;
        MessageProducer producer = null;
        Session session = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, ActiveMQSession.AUTO_ACKNOWLEDGE);
//          session = connection.createSession(Boolean.TRUE, ActiveMQSession.SESSION_TRANSACTED);
            int acknowledgeMode = session.getAcknowledgeMode();
            boolean transacted = session.getTransacted();
            //  创建队列
            Topic topic = session.createTopic(queueName);
            session.createMessage();
            TextMessage textMessage = session.createTextMessage(message);
            System.out.println(textMessage.toString());
            producer = session.createProducer(topic);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//非持久化
            producer.send(textMessage);
            session.commit();
        } catch (JMSException e) {
            System.out.println("消息发送失败！");
            e.printStackTrace();
        } finally {
            if(producer!=null){
                producer.close();
            }
            if(session!=null){
                session.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
    }
}
