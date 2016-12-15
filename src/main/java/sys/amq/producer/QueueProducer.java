package sys.amq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.util.Map;
import java.util.Set;

/**
 * author: zf
 * Date: 2016/12/6  13:51
 * Description:队列式消息生成者
 */
@Component("queueProducer")
public class QueueProducer {
    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;//通过@Qualifier修饰符来注入对应的bean

    /**
     * 发送一条消息到指定的队列（目标）
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void send(String queueName,final String message){
//        设置持久化,默认持久化
//        jmsTemplate.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//        jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
        jmsTemplate.send(queueName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
  
                return session.createTextMessage(message);
            }
        });
    }
    
    public void sendMapMessage(String des,final Map<String,String> map){
        jmsTemplate.send(des, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                for (Map.Entry<String,String> en: map.entrySet()) {
                    mapMessage.setString(en.getKey(),en.getValue());
                }
                System.out.println(mapMessage.toString());
                return mapMessage;
            }
        });
    }

}
