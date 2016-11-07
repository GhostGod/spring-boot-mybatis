package tk.mybatis.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	
	@Autowired
	private StringRedisTemplate template;

	public void put(String key, String value) {
		template.boundValueOps(key).set(value);
	}

	public Object get(String key) {
		return template.boundValueOps(key).get();
	}

	public void remove(String key) {
		template.delete(key);
	}
}
