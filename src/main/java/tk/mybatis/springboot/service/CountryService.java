package tk.mybatis.springboot.service;

import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.springboot.mapper.CountryMapper;
import tk.mybatis.springboot.model.Country;
import tk.mybatis.springboot.vo.Test;

import java.util.List;

/**
 * 
 * @author liuyang
 * @Email y_liu@hiersun.com | 745089707@qq.com
 * @Date 2016年11月8日
 */
@Service
public class CountryService {

	@Autowired
	private CountryMapper countryMapper;

	public List<Country> getAll(Country country) {
		if (country.getPage() != null && country.getRows() != null) {
			PageHelper.startPage(country.getPage(), country.getRows(), "id");
		}
		return countryMapper.selectAll();
	}

	public Country getById(Integer id) {
		return countryMapper.selectByPrimaryKey(id);
	}

	public void deleteById(Integer id) {
		countryMapper.deleteByPrimaryKey(id);
	}

	public void save(Country country) {
		if (country.getId() != null) {
			countryMapper.updateByPrimaryKey(country);
		} else {
			countryMapper.insert(country);
		}
	}

	public List<Test> test(int pageIndex, int pageSize) {
		return countryMapper.test(pageIndex, pageSize);
	}
}
