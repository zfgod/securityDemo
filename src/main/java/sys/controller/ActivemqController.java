package sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sys.amq.producer.SessionQueueProducer;
import sys.amq.producer.QueueProducer;
import sys.amq.producer.TopicProducer;
import sys.model.AmqObject;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liang
 * @description controller测试
 * /letGo 是系统放行匹配规则的设置
 */
@Controller
@RequestMapping("/activemq")
public class ActivemqController {
	
	@Resource
	SessionQueueProducer sessionQueueProducer;
	@Resource
	QueueProducer queueProducer;
	@Resource
	TopicProducer topicSender;
	
	/**
	 * 发送消息到队列
	 * Queue队列：仅有一个订阅者会收到消息，消息一旦被处理就不会存在队列中
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("/letGo/queueSender")
	public String queueSender(@RequestParam("name")String name,
							  @RequestParam("message")String message){
		String opt="";
		try {
			sessionQueueProducer.sendQueueMsg(name, message);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}
	
	/**
	 * 发送消息到主题
	 * Topic主题 ：放入一个消息，所有订阅者都会收到 
	 * 这个是主题目的地是一对多的
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("/letGo/topicSender")
	public String topicSender(@RequestParam("message")String message){
		String opt = "";
		try {
			topicSender.send("test.topic", message);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}

	@ResponseBody
	@RequestMapping("/letGo/topicObject")
	public String topicObject(@RequestParam("destination")String destination
			,@RequestParam("msg")String msg){
		String opt = "";
		try {
			AmqObject o = new AmqObject();
			o.setName(destination);
			o.setMsg(msg);
			topicSender.sendAmqObject(destination, o);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}

	@ResponseBody
	@RequestMapping("/letGo/topicMap")
	public String queueMap(@RequestParam("destination")String destination
			,@RequestParam("msg")String msg){
		String opt = "";
		try {
			Map<String,String> o = new HashMap();
			o.put("msg",msg);
			topicSender.sendAmqMap(destination, o);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}
	
}
