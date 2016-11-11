package tk.mybatis.springboot.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.hiersun.xzkp.service.SmsService;

@Configuration
public class DubboConfig {
	public static final String APPLICATION_NAME = "sms-consumer";

	public static final String REGISTRY_ADDRESS = "127.0.0.1";

	public static final String ANNOTATION_PACKAGE = "tk.mybatis.springboot.controller";

	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(APPLICATION_NAME);
		return applicationConfig;
	}

	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress(REGISTRY_ADDRESS);
		return registryConfig;
	}

	@Bean
	public AnnotationBean annotationBean() {
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage(ANNOTATION_PACKAGE);
		return annotationBean;
	}

	@Bean
	public SmsService smsService() {
		ReferenceConfig<SmsService> referenceConfig = new ReferenceConfig<>();
		referenceConfig.setApplication(applicationConfig());
		referenceConfig.setInterface(SmsService.class);
		referenceConfig.setUrl("dubbo://127.0.0.1:20880/com.hiersun.xzkp.service.SmsService");
		referenceConfig.setId("smsService");
		referenceConfig.destroy();
		return referenceConfig.get();
	}
}
