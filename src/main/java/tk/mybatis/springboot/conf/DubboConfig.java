package tk.mybatis.springboot.conf;

import org.springframework.context.annotation.Bean;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;

//@Configuration
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
}
