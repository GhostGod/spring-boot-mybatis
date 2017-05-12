package tk.mybatis.springboot.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.mybatis.springboot.model.Country;
import tk.mybatis.springboot.service.CountryService;
import tk.mybatis.springboot.service.RedisService;
/**
 * redis控制器
 * @author liuyang
 * @Email y_liu@hiersun.com | 745089707@qq.com
 * @Date 2016年11月7日
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisService redisService;
	@Autowired
	private CountryService countryService;

	@RequestMapping("put")
	public String put() {
		redisService.put("123", "乱码");
		return "put ok";
	}

	@RequestMapping(value = "get", produces = "text/html;charset=UTF-8")
	public String get() {
		Object o = redisService.get("123");
		return "123=" + (String) o;
	}

	@RequestMapping("delete")
	public String delete() {
		redisService.remove("123");
		return "delete ok";
	}

	@RequestMapping("putC")
	public String putCountry() throws UnsupportedEncodingException {
		Country c = new Country();
		c.setCountrycode("110101");
		//c.setCountryname(new String("北京".getBytes(), "UTF-8"));
		c.setCountryname("北京");
		//countryService.save(c);
		redisService.putcountry("country", c);
		return "put ok";
	}

	@RequestMapping(value = "getC", produces = "text/html;charset=UTF-8")
	public String getCountry() {
		Country c = redisService.getcountry("country");
		return "country=" + c;
	}

	@RequestMapping("deleteC")
	public String deleteCountry() {
		redisService.removecountry("country");
		return "delete ok";
	}
}
