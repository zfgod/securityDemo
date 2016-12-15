package sys.amq.producer;

import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * author: zf
 * Date: 2016/12/6  13:51
 * Description: 注入连接工厂
 *    自定义消息:消息类型,消息名称,事务,响应模式,消息生成者,消息体,传送模式
 *    手动开启、关闭：连接,session,生产者
 */
@Component("sessionQueueProducer")
public class SessionQueueProducer {

    @Autowired
    @Qualifier("amqConnectionFactory")
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
            RedeliveryPolicy redeliveryPolicy = connectionFactory.getRedeliveryPolicy();
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, ActiveMQSession.CLIENT_ACKNOWLEDGE);
//          session = connection.createSession(Boolean.TRUE, ActiveMQSession.SESSION_TRANSACTED);
            int acknowledgeMode = session.getAcknowledgeMode();
            boolean transacted = session.getTransacted();
            //session.createQueue  创建点对点队列
            Queue queue = session.createQueue(queueName);
            session.createMessage();
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
