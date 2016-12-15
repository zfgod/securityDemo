package sys.amq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import sys.model.AmqObject;

import javax.jms.*;
import java.util.Map;

/**
 * author: zf
 * Date: 2016/12/6  13:51
 * Description:发布/订阅式消息生成者
 */
@Component("topicProducer")
public class TopicProducer {
    @Autowired
    @Qualifier("jmsTopicTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 发送一条消息到指定的队列（目标）
     * @param topicName 队列名称
     * @param message 消息内容
     */
    public void send(String topicName,final String message){
        jmsTemplate.send(topicName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

    public void sendAmqObject(String destination, final AmqObject o){
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage(o);
                objectMessage.setObject(o);
                String s = objectMessage.toString();
                System.out.println(s);
                return objectMessage;
            }
        });
    }

    public void sendAmqMap(String destination, final Map<String,String> o){
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                for (Map.Entry<String, String> entry : o.entrySet()) {
                    mapMessage.setString(entry.getKey(),entry.getValue());
                }
                System.out.println(mapMessage.toString());
                return mapMessage;
            }
        });
    }
}
