package tk.mybatis.springboot.controller;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tk.mybatis.springboot.model.Country;
import tk.mybatis.springboot.service.CountryService;
import tk.mybatis.springboot.vo.Test;

import com.github.pagehelper.PageInfo;

/**
 * 
 * @author liuyang
 * @Email y_liu@hiersun.com | 745089707@qq.com
 * @Date 2016年11月8日
 */
@Controller
@RequestMapping(value = "/countries", produces = "text/html;charset=UTF-8")
public class CountryController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private Validator validator;

	@RequestMapping
	public ModelAndView getAll(Country country) {
		ModelAndView result = new ModelAndView("index");
		List<Country> countryList = countryService.getAll(country);
		result.addObject("pageInfo", new PageInfo<Country>(countryList));
		result.addObject("queryParam", country);
		result.addObject("page", country.getPage());
		result.addObject("rows", country.getRows());
		return result;
	}

	@RequestMapping(value = "/add")
	public ModelAndView add() {
		ModelAndView result = new ModelAndView("view");
		result.addObject("country", new Country());
		return result;
	}

	@RequestMapping(value = "/view/{id}")
	public ModelAndView view(@PathVariable Integer id) {
		ModelAndView result = new ModelAndView("view");
		Country country = countryService.getById(id);
		result.addObject("country", country);
		return result;
	}

	@RequestMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable Integer id, RedirectAttributes ra) {
		ModelAndView result = new ModelAndView("redirect:/countries");
		countryService.deleteById(id);
		ra.addFlashAttribute("msg", "删除成功!");
		return result;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Country country) {
		ModelAndView result = new ModelAndView("view");
		String msg = country.getId() == null ? "新增成功!" : "更新成功!";
		countryService.save(country);
		result.addObject("country", country);
		result.addObject("msg", msg);
		return result;
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public String test() {
		String result = "";
		for (Test test : countryService.test(0, 10)) {
			result = result + ", " + test.toString();
		}
		return result;
	}

}