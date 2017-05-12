package tk.mybatis.springboot.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tk.mybatis.springboot.model.Country;
import tk.mybatis.springboot.service.CountryService;
/**
 * Hibernate Validator控制器
 * @author liuyang
 * @Email y_liu@hiersun.com | 745089707@qq.com
 * @Date 2016年11月8日
 */
@Controller
@RequestMapping(value = "/validator", produces = "text/html;charset=UTF-8")
public class ValidatorController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private Validator validator;

	@RequestMapping(value = "/add1")
	@ResponseBody
	public String testadd(@Valid Country country, Errors errors) {
		if (errors.hasErrors()) {
			return errors.toString();
		}
		String result = "";
		countryService.save(country);
		return result;
	}

	@RequestMapping(value = "/add2")
	@ResponseBody
	public String testvalidator(Country country) {
		country.setCountrycode("110100");
		Set<ConstraintViolation<Country>> set = validator.validate(country);
		if (set.size() > 0) {
			String result = country.toString() + ":";
			for (ConstraintViolation<Country> c : set) {
				result = result + c.getMessage() + ",";
			}
			return result;
		} else {
			return "ok";
		}
	}
}
