package sys.amq.consumer;

import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * author: zf
 * Date: 2016/12/6  13:52
 * Description:队列式消息接收者
 */
@Component
public class QueueConsumer1Back implements SessionAwareMessageListener<Message> {

    @Override
    public void onMessage(Message message,Session session) {
        try {
            if (message instanceof TextMessage) {
                System.out.println("收到一条消息");
                System.out.println("消息内容是：" + ((TextMessage) message).getText());
                int acknowledgeMode = session.getAcknowledgeMode();
                boolean transacted = session.getTransacted();
                session.rollback();
//                session.
                System.out.println("未手动确认消息");
            } else {
                System.out.println("Consumer:->Received: " + message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
