package sys.amq.consumer;

import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * author: zf
 * Date: 2016/12/6  13:52
 * Description:队列式消息接收者
 *  int AUTO_ACKNOWLEDGE = 1;
    int CLIENT_ACKNOWLEDGE = 2;
    int DUPS_OK_ACKNOWLEDGE = 3;
   》》 int SESSION_TRANSACTED = 0;
 */
@Component
public class QueueTransactionalAckConsumer implements SessionAwareMessageListener {
    /**
     * 监听消息：事务型消息确认
     *      1.消息处理前 不会告知  消息代理已成功接收消息,
     *         名称为此消息队列名称的信息
     *         queue接收到消息时队列中显示：
     *              Number Of Pending Messages  等待消费的消息  +1
     *              Messages Enqueued           进入队列的消息  +1
     *              Messages Dequeued           出了队列的消息  保持不变
     *      2.消息处理过程中及消息处理完毕：
     *           2.1 过程中无异常,待消息处理完毕：（与接收到消息时作对比）
     *              Number Of Pending Messages  等待消费的消息  -1
     *              Messages Enqueued           进入队列的消息  保持不变
     *              Messages Dequeued           出了队列的消息  +1
     *           2.2 过程中有异常,消息处理终止,告知消息处理失败
     *              第一次接收消息处理出异常：此消息处于等待消费
     *              接着再次接收消息6遍,过程中消息一直处于等待消费状态
     *              重复6次之后（一共接收7遍）,消费者不再监听到消息。
     *                2.2.1 消息处理完毕消息代理的处理：
     *                      此消息如果发送设置Persistent Delivery=false
     *                           则离开此消息名称队列
     *                      此消息如果发送设置Persistent Delivery=true
     *                          则离开此消息名称队列,但是消息内容被放入queue队列,名称为ActiveMQ.DLQ（deadLetterQueue死信队列）
     *               2.2.2 消息重复接收6次分析：
     *                   a.异常出现后没有进入catch块,而是抛出交给jms去执行内置的ack指令返回
     *                      跟踪后续处理。。尝试查看返回给broker的ack_type,但是没有看到这方面的处理
     *                     那么基于ack_type指令的定义：猜测执行如下
     *                       分析是在出现异常后发送ack_type = REDELIVERED_ACK_TYPE(需重发)
     *                       当重复次数到达6此之后 ack_type = POSION_ACK_TYPE (抛弃)
     *                   b.异常出现后异常被捕捉处理
     *                       session会进行commit,并且消息处理返回后,消息从此监听队列中移出,没有进入死信队列
     *              疑问：
     *                   没有catch异常时重复接收的处理，消息重发策略
     *                   进入死信队列的消息怎么处理
     *                   出现异常的消息能不能让broker对他进行保留
     *              问题分析及解决：学习并自定义 redelivery Policy 重投策略
     *                      私信队列学习并定义,以及后续分析私信队列内容
     *
      ----------------   重投策略和死信队列结合spring的配置，brokerUrl可以携带参数，
                                        配置文件也保留了，也许单独的activemq服务更容易去优化吧
           这里就按默认的activemq broker，redelivery policy 做相应的处理：
                           catch 所有异常,在catch块中对异常做处理,处理内容包括记录消息内容,异常内容等
                                 并且捕捉处理的内容,防止处理过程异常导致重投
     * 消息场景分析：
     *
     *
     */
    @Override
    public void onMessage(Message message,Session session) {
        try {
            if (message instanceof TextMessage) {
                boolean jmsRedelivered = message.getJMSRedelivered();
                int jmsDeliveryMode = message.getJMSDeliveryMode();
                System.out.println("消息内容是：" + ((TextMessage) message).getText());
                int acknowledgeMode = session.getAcknowledgeMode();
                System.out.println("消息确认类型："+acknowledgeMode);
                boolean transacted = session.getTransacted();
                System.out.println("事务状态:" +transacted);
//              异常测试
                int i = 1/0;

/* 无异常状况结果：
 收到一条消息
 消息内容是：事务成功
 消息确认类型：0
 事务状态:true */

/*
  有异常结果
 接收消息执行总次数：7
 重试接收此消息次数：6
* */
            } else {
                System.out.println("Consumer:->Received: " + message);
            }
        }
        catch (JMSException e) {
            e.printStackTrace();
        }
//模拟异常没有被catch,可注释此catch块
//        catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
