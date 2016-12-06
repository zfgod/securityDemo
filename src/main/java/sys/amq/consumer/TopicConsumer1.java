package sys.amq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * author: zf
 * Date: 2016/12/6  13:52
 * Description:发布/订阅式消息接收者
 */
@Component
public class TopicConsumer1{
//    @JmsListener(containerFactory = "jmsListenerContainerFactory",destination = "test.topic")
    public void quemeMessage(Message message) {
        try {
            System.out.println("TopicReceiver1接收到消息:"+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
