package resource.redis;

import redis.clients.jedis.Jedis;

/**
 * author: zf
 * Date: 2017/2/14  14:46
 * Description:
 */
public class JedisDemo {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		jedis.set("hello","jedis-redis");
		String hello = jedis.get("hello");
		System.out.println(hello);
	}
}
