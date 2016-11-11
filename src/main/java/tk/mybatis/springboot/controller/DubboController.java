package tk.mybatis.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiersun.xzkp.service.SmsService;

@RestController
public class DubboController {

	@Autowired
	private SmsService smsService;

	@RequestMapping("dubbo")
	public boolean dubbo() {
		return smsService.send("18686637936", "您好，您的验证码是：123456", "test", "test");
	}
}
