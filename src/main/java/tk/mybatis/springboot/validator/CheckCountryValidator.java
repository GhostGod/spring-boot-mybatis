package tk.mybatis.springboot.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tk.mybatis.springboot.model.Country;

/**
 * 自定义实体验证器
 * @author liuyang
 * @Email y_liu@hiersun.com | 745089707@qq.com
 * @Date 2016年11月7日
 */
public class CheckCountryValidator implements ConstraintValidator<CheckCountry, Country> {

	@Override
	public void initialize(CheckCountry arg0) {

	}

	@Override
	public boolean isValid(Country country, ConstraintValidatorContext context) {
		if (country == null) {
			return true;
		}
		if (country.getCountrycode() == "110101") {
			return true;
		}
		return false;
	}

}
