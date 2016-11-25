package sys.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author: zf
 * Date: 2016/11/18  9:37
 * Description:
 */
public class TestJobClass {

    private static final Logger logger = LoggerFactory.getLogger(TestJobClass.class);
    private static long count;
    public synchronized void testJob(){
        String name = this.getClass().getName();
        int hashCode = this.getClass().hashCode();
        long id = Thread.currentThread().getId();
        logger.info("thread"+id+"--开始job--当前类"+name+hashCode);
        for(int i= 0;i<5;i++){
            logger.info("thread"+id+"读取到count值:"+count++);
        }
        logger.info("thread"+id+"--完成job--当前类"+name+hashCode);
    }
}
