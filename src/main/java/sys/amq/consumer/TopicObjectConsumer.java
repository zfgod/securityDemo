package sys.amq.consumer;

import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;
import sys.model.AmqObject;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;

/**
 * author: zf
 * Date: 2016/12/13  16:17
 * Description:
 */
@Component
public class TopicObjectConsumer implements SessionAwareMessageListener{


    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        try {
            if(message instanceof ObjectMessage){
                Serializable s = ((ObjectMessage) message).getObject();
                System.out.println(s.toString());
                AmqObject object = (AmqObject) s;
                System.out.println(object.toString());
            }else {
                System.out.println(message.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
