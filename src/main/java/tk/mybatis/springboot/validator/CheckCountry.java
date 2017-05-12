package tk.mybatis.springboot.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 自定义验证注解
 * @author liuyang
 * @Email y_liu@hiersun.com | 745089707@qq.com
 * @Date 2016年11月7日
 */
@Target({ ElementType.FIELD,ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckCountryValidator.class)
@Documented
public @interface CheckCountry {
	String message() default "{org.hibernate.validator.mybatis.CheckCountry.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
