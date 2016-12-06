package sys.amq.consumer;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * author: zf
 * Date: 2016/12/6  13:52
 * Description:队列式消息接收者
 */
@Component
public class QueueConsumer2 implements MessageListener{
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("queueReceiver2接收到消息:"+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}