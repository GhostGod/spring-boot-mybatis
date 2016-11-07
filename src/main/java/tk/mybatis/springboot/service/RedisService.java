package tk.mybatis.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import tk.mybatis.springboot.model.Country;

@Service
public class RedisService {

	@Autowired
	private StringRedisTemplate template;
	@Autowired
	private RedisTemplate<String, Country> countryRedisTemplate;

	public void put(String key, String value) {
		template.boundValueOps(key).set(value);
	}

	public Object get(String key) {
		return template.boundValueOps(key).get();
	}

	public void remove(String key) {
		template.delete(key);
	}
	
	public void putcountry(String key, Country value) {
		countryRedisTemplate.boundValueOps(key).set(value);
	}

	public Country getcountry(String key) {
		return countryRedisTemplate.boundValueOps(key).get();
	}

	public void removecountry(String key) {
		countryRedisTemplate.delete(key);
	}
}
