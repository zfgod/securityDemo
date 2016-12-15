package sys.amq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * author: zf
 * Date: 2016/12/6  13:52
 * Description:队列式消息接收者
 */
@Component
public class QueueAutoAckConsumer implements SessionAwareMessageListener<Message> {

    @Autowired
    @Qualifier("amqConnectionFactory")
    private ActiveMQConnectionFactory connectionFactory;//如果需要返回某个队列消息
    /**
     * 监听消息：自动确认消息模式
     *      1.消息处理前就已经告知消息代理已成功接收消息,
     *        此时消息queue队列中显示：名称为此消息队列名称的信息
     *              Number Of Pending Messages  等待消费的消息  保持不变
     *              Messages Enqueued           进入队列的消息  +1
     *              Messages Dequeued           出了队列的消息  +1
     *      2.消息处理过程中及消息处理完毕：
     *             无论是否产生异常，是否成功处理数据，此消息都已经被消费且出了队列
     * 消息场景分析：
     *     消息到来即确认,无需关心处理的结果
     */
    @Override
    public void onMessage(Message message,Session session) {
        try {
            if (message instanceof TextMessage) {
                //消息处理出现异常
//                int i = 1/0;
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
                System.out.println("Consumer:->Received: " + message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
