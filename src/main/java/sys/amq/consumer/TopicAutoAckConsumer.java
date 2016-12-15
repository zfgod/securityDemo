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
public class TopicAutoAckConsumer implements SessionAwareMessageListener {
    /**
     * 消息监听:
     *   1.当消息到来时：
     *      此时消息队列中显示：
     *              Messages Enqueued           进入队列的消息  +1
     *              Messages Dequeued           出了队列的消息  不变
     *   2.消息处理完毕：
     *           正常处理无异常： 消息没有第一时间出队列
     *      -- 消费者监听关闭（监听服务停止）,消息离开队列
     *           消息处理出异常：
     *                  消息抛出或者捕捉：消息直接出队列
          -- 之后测试都是消息被接收就直接显示出队列数加1
        疑问：订阅式消息确认机制

     */
    @Override
    public void onMessage(Message message,Session session) {
        try {
            System.out.println("消息内容是：" + ((TextMessage) message).getText());
            int acknowledgeMode = session.getAcknowledgeMode();
            System.out.println("消息确认类型："+acknowledgeMode);
            boolean transacted = session.getTransacted();
            System.out.println("事务状态:" +transacted);
//            模拟异常
            int i = 1/0;
        } catch (JMSException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
