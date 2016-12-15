package sys.amq.consumer;

import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.*;


/**
 * author: zf
 * Date: 2016/12/6  13:52
 * Description:发布/订阅式消息接收者
 */
@Component
public class TopicClientAckConsumer implements SessionAwareMessageListener {
    /**
     *
     * @param message
     * @param session
     *
     * 消息监听：
     *     消息到来，进入队列数加1，出入队列数不变
     *     消息处理：
     *          消息监听正常处理完成出入队列数加1
     *          消息处理进行session.recover(),进入重投策略,直到完成，消息离开队列
     *          消息处理出异常：
     *              异常抛出：进入重投策略，完成后消息离开队列
     *              异常捕捉：消息直接离开队列
     */
    @Override
    public void onMessage(Message message,Session session) {
        try {
            System.out.println("消息内容是：" + ((TextMessage) message).getText());
            int acknowledgeMode = session.getAcknowledgeMode();
            System.out.println("消息确认类型："+acknowledgeMode);
            boolean transacted = session.getTransacted();
            System.out.println("事务状态:" +transacted);
//            session.recover();//需重发，重发策略走完，消息离开队列
//            int i = 1/0;
        } catch (JMSException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
