package sys.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import resource.redis.RedisService;

/**
 * author: zf
 * Date: 2017/2/14  15:23
 * Description:
 */
@Controller
@RequestMapping("redis/letGo")
public class RedisDemoController extends BaseController{
	@Autowired
	RedisService redisService;
	@RequestMapping(value = "/string")
	@ResponseBody
	public String setString(@RequestParam("key") String key,@RequestParam("value") String value){
		return redisService.set(key,value);
	}
}
