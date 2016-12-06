/*
package common.utils;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.MapMessage;

*/
/**
 * author: zf
 * Date: 2016/12/6  17:53
 * Description:http://blog.csdn.net/lisaem/article/details/51858437?locationNum=2&fps=1
 *//*

public class ActiveMQUtils {

    */
/**
     * 向默认队列发送text消息
     *//*

    public void sendMessage(JmsTemplate jmsTemplate,final String msg) {
        String destination = jmsTemplate.getDefaultDestination().toString();
        System.out.println("ProducerService向队列" + destination + "发送了消息：\t" + msg);
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

    */
/**
     * 向默认队列发送map消息
     *//*

    public void sendMapMessage() {
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setString("name", "小西山");
                return message;
            }
        });
    }

    */
/**
     * 向默认队列发送Object消息
     *//*

    public void sendObjectMessage() {
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                Staff staff = new Staff(1, "搬砖工"); // Staff必须实现序列化
                ObjectMessage message = session.createObjectMessage(staff);
                return message;
            }
        });
    }

    */
/**
     * 向默认队列发送Bytes消息
     *//*

    public void sendBytesMessage() {
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                String str = "BytesMessage 字节消息";
                BytesMessage message = session.createBytesMessage();
                message.writeBytes(str.getBytes());
                return message;
            }
        });
    }

    */
/**
     * 向默认队列发送Stream消息
     *//*

    public void sendStreamMessage() {
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                String str = "StreamMessage 流消息";
                StreamMessage message = session.createStreamMessage();
                message.writeString(str);
                message.writeInt(521);
                return message;
            }
        });
    }
}
*/
