package tk.mybatis.springboot.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import tk.mybatis.springboot.model.Country;

@Configuration
public class RedisConfig {
	@Autowired
	public JedisConnectionFactory jedisConnectionFactory;

	@Bean
	public RedisTemplate<String, Country> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Country> template = new RedisTemplate<String, Country>();
		template.setConnectionFactory(jedisConnectionFactory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new JdkSerializationRedisSerializer());
		return template;
	}
	
}
