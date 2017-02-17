package resource.redis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * * author: zf
 * Date: 2017/2/14  14:46
 * Description:
 */
@Service
public class RedisService {

    @Autowired(required = false)//如果容器中有就注入，如果没有就忽略
    private ShardedJedisPool shardedJedisPool;

    public <T> T execute(Function<ShardedJedis, T> fun) {
        ShardedJedis shardedJedis = null;
        try {
            // 从连接池中获取到jedis分片对象
            shardedJedis = shardedJedisPool.getResource();
            return fun.callback(shardedJedis);
        } finally {
            if (null != shardedJedis) {
                // 关闭，检测连接是否有效，有效则放回到连接池中，无效则重置状态
                shardedJedis.close();
            }
        }
    }
    
    /**
     * 存储hash结果数据
     * @param key
     * @return
     */
    public String setMap(final String key, final Map<String,String> hash) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String callback(ShardedJedis e) {
                
                return e.hmset(key, hash);
            }
        });
    }
    
    /**
     * 存储map中某个filed的值
     * @param key,field,value
     * @return
     */
    public Long setMapFiled(final String key, final String field,final String value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.hset(key, field, value);
        } finally{
            if (null != shardedJedis) {
                shardedJedis.close();
            }
        }
    }
    
    /**
     * 判断redis中是否存在这个key
     */
    public Boolean exists(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.exists(key);
        } finally{
            if (null != shardedJedis) {
                shardedJedis.close();
            }
        }
    }
    /**
     * map中filed是否存在的判断
     * 判断redis中是否存在这个key
     */
    public Boolean hexists(String key,String field) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.hexists(key,field);
        } finally{
            if (null != shardedJedis) {
                shardedJedis.close();
            }
        }
    }
    /**
     * 从Redis中获取指定map
     * @param key
     * @return
     */
    public Map<String, String> hget(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            Map<String, String> map = shardedJedis.hgetAll(key);
            return map;
        } finally{
            if (null != shardedJedis) {
                shardedJedis.close();
            }
        }
    }
    
    /**
     * 从Redis中获取指定map中某个filed的值
     * @param key,filed
     * @return
     */
    public String hget(String key,String filed) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            String value = shardedJedis.hget(key,filed);
            return value;
        } finally{
            if (null != shardedJedis) {
                shardedJedis.close();
            }
        }
    }
    
    


    /**
     * 保存数据到Redis
     * 
     * @param key
     * @param value
     * @return
     */
    public String set(final String key, final String value) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String callback(ShardedJedis e) {
                return e.set(key, value);
            }
        });
    }
    
    
    /**
     * 从Redis中获取数据
     * 
     * @param key
     * @return
     */
    public String get(final String key) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String callback(ShardedJedis e) {
                return e.get(key);
            }
        });
    }

    /**
     * 保存数据到Redis并且设置生存时间，单位为秒
     * 
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public String set(final String key, final String value, final Integer seconds) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String callback(ShardedJedis e) {
                String result = e.set(key, value);
                e.expire(key, seconds);
                return result;
            }
        });
    }

    /**
     * 设置生存时间，单位为秒
     * 
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(final String key, final Integer seconds) {
        return this.execute(new Function<ShardedJedis, Long>() {
            @Override
            public Long callback(ShardedJedis e) {
                return e.expire(key, seconds);
            }
        });
    }
    
    /**
     * 根据key删除数据
     * 
     * @param key
     * @return
     */
    public Long del(final String key){
        return this.execute(new Function<ShardedJedis, Long>() {
            @Override
            public Long callback(ShardedJedis e) {
                return e.del(key);
            }
        });
    }
    /**
     * 删除hash结构数据中的某个field
     * @param key
     * @param field
     * @return 
     */
    public Long hdel(final String key, final String field) {
        return this.execute(new Function<ShardedJedis, Long>() {
            @Override
            public Long callback(ShardedJedis e) {
                return e.hdel(key, field);
            }
        }); 
        
    }
    
 
}
