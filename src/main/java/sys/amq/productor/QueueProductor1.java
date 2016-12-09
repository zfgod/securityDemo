package sys.amq.productor;

import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * author: zf
 * Date: 2016/12/6  13:51
 * Description: 队列式消息生成者
 */
@Component("queueProductor1")
public class QueueProductor1 {
    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;//通过@Qualifier修饰符来注入对应的bean
    @Autowired
    private ActiveMQConnectionFactory connectionFactory;



    /**
     * 发送一条消息到指定的队列（目标）
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void sendQueueMsg(String queueName,final String message) throws JMSException {
        Connection connection = null;
        MessageProducer producer = null;
        Session session = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, ActiveMQSession.CLIENT_ACKNOWLEDGE);
//            session = connection.createSession(Boolean.TRUE, ActiveMQSession.INDIVIDUAL_ACKNOWLEDGE);
            int acknowledgeMode = session.getAcknowledgeMode();
            boolean transacted = session.getTransacted();
            Queue queue = session.createQueue(queueName);
            TextMessage textMessage = session.createTextMessage(message);
            System.out.println(textMessage.toString());
            producer = session.createProducer(queue);
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
