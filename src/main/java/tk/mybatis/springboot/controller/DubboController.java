package tk.mybatis.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hiersun.xzkp.service.SmsService;

@RestController
public class DubboController {

	@Reference(interfaceClass = SmsService.class)
	private SmsService smsService;

	@RequestMapping("dubbo")
	public boolean dubbo() {
		return smsService.send("18686637936", "您好，您的验证码是：123456", "test", "test");
	}
}
