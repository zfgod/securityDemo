package sys.amq.consumer;

import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;
import sys.model.AmqObject;

import javax.jms.*;
import java.io.Serializable;

/**
 * author: zf
 * Date: 2016/12/6  13:52
 * Description:队列式消息接收者
 */
@Component
public class QueueClientAckConsumer implements SessionAwareMessageListener {

    /**
     * 监听消息：客户端自定义消息确认
     *      1.消息处理前就已经告知消息代理已成功接收消息,
     *        此时消息queue队列中显示：名称为此消息队列名称的信息
     *              Number Of Pending Messages  等待消费的消息  +1
     *              Messages Enqueued           进入队列的消息  +1
     *              Messages Dequeued           出了队列的消息  不变
     *      2.消息处理过程中及消息处理完毕：
     *             无论是否产生异常，是否成功处理数据，此消息都已经被消费且出了队列
     *              Number Of Pending Messages  等待消费的消息  -1
     *              Messages Enqueued           进入队列的消息  不变
     *              Messages Dequeued           出了队列的消息  +1
     *   异常或者处理未成功,处理都应该记录消息及失败原因，跳过重投
     *
     * 消息场景分析：
     *     消息到来即确认,无需关心处理的结果
     */
    @Override
    public void onMessage(Message message,Session session) {
        try {
            if(message instanceof ObjectMessage){
                Serializable serializable = ((ObjectMessage) message).getObject();
                System.out.println(serializable.toString());
                AmqObject object = (AmqObject) serializable;
                System.out.println(object.toString());
            }
//           System.out.println("收到一条消息");
            System.out.println("消息内容是：" + ((TextMessage) message).getText());
            int acknowledgeMode = session.getAcknowledgeMode();
            System.out.println("消息确认类型："+acknowledgeMode);
            boolean transacted = session.getTransacted();
            System.out.println("事务状态:" +transacted);
//            session.recover();//告知重发
        } catch (JMSException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}