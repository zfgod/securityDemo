package sys.amq.config;

import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * author: zf
 * Date: 2016/12/12  18:09
 * Description:
 */
public class MyRedeliveryPolicy  extends RedeliveryPolicy{
    @Autowired
    private ActiveMQConnectionFactory connectionFactory;

    public MyRedeliveryPolicy() {
        super();
        this.redeliveryDelay = this.initialRedeliveryDelay;
    }
}
