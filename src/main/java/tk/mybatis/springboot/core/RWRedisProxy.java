package tk.mybatis.springboot.core;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class RWRedisProxy<K, V> extends RedisTemplate<K, V> {

	private RedisTemplate<K, V> master = new RedisTemplate<K, V>();
	private RedisTemplate<K, V> slave = new RedisTemplate<K, V>();

	public RWRedisProxy() {
	}

	@Override
	public BoundValueOperations<K, V> boundValueOps(K key) {
		// TODO Auto-generated method stub
		return super.boundValueOps(key);
	}

	@Override
	public BoundListOperations<K, V> boundListOps(K key) {
		// TODO Auto-generated method stub
		return super.boundListOps(key);
	}

	@Override
	public BoundSetOperations<K, V> boundSetOps(K key) {
		// TODO Auto-generated method stub
		return super.boundSetOps(key);
	}

	@Override
	public BoundZSetOperations<K, V> boundZSetOps(K key) {
		// TODO Auto-generated method stub
		return super.boundZSetOps(key);
	}

	@Override
	public <HK, HV> BoundHashOperations<K, HK, HV> boundHashOps(K key) {
		// TODO Auto-generated method stub
		return super.boundHashOps(key);
	}

}
