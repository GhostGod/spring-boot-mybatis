package tk.mybatis.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.mybatis.springboot.service.RedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	private RedisService redisService;

	@RequestMapping("put")
	public String put() {
		redisService.put("123", "test");
		return "put ok";
	}

	@RequestMapping("get")
	public String get() {
		redisService.get("123");
		return "123=" + (String) redisService.get("123");
	}

	@RequestMapping("delete")
	public String delete() {
		redisService.remove("123");
		return "delete ok";
	}
}
