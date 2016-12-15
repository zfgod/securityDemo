package sys.amq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * author: zf
 * Date: 2016/12/6  13:52
 * Description:死信队列 消息分析
 */
@Component
public class QueueDLQConsumer implements SessionAwareMessageListener<Message> {

    @Autowired
    @Qualifier("amqConnectionFactory")
    private ActiveMQConnectionFactory connectionFactory;//如果需要返回某个队列消息
    /**
     * 监听消息：
               内容都进行了保存，可以获取
     */
    @Override
    public void onMessage(Message message,Session session) {
        try {
            if (message instanceof TextMessage) {
                //消息处理出现异常
//              int i = 1/0;
                System.out.println("消息内容是：" + ((TextMessage) message).getText());
                int acknowledgeMode = session.getAcknowledgeMode();
                System.out.println("消息确认类型："+acknowledgeMode);
                boolean transacted = session.getTransacted();
                System.out.println("事务状态:" +transacted);
//                message.acknowledge();
//消息内容是：c
//消息确认类型：1
//事务状态:false
            } else {
                String jmsType = message.getJMSType();
                System.out.println(message.toString());
                System.out.println("Consumer:->Received: " + message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
