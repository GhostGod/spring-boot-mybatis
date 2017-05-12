package tk.mybatis.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xxxx.common.SmsService;

@RestController
public class DubboController {

	//@Reference
	@Autowired
	private SmsService smsService;

	@RequestMapping("dubbo")
	public boolean dubbo() {
		return smsService.send("18686637936", "您好，您的验证码是：123456", "test", "test","test");
	}
}
