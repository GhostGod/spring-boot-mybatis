package tk.mybatis.springboot.conf;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
/**
 * 验证器配置
 * @author liuyang
 * @Email y_liu@hiersun.com | 745089707@qq.com
 * @Date 2016年11月8日
 */
@Configuration
public class ValidatorConfig {

	@Bean
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setBasename("classpath:validator");
		ms.setDefaultEncoding("UTF-8");
		ms.setUseCodeAsDefaultMessage(false);
		return ms;
	}
	
	@Bean
	public LocalValidatorFactoryBean getLocalValidatorFactoryBean() {
		LocalValidatorFactoryBean fb = new LocalValidatorFactoryBean();
		fb.setProviderClass(HibernateValidator.class);
		fb.setValidationMessageSource(getMessageSource());
		return fb;
	}
}
