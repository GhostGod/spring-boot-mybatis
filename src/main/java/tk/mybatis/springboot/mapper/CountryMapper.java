package tk.mybatis.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tk.mybatis.springboot.model.Country;
import tk.mybatis.springboot.util.MyMapper;
import tk.mybatis.springboot.vo.Test;
/**
 * 
 * @author liuyang
 * @Email y_liu@hiersun.com | 745089707@qq.com
 * @Date 2016年11月8日
 */
public interface CountryMapper extends MyMapper<Country> {

	@Select("SELECT test_abc AS testAbc FROM city INNER JOIN country ON country.Id=city.id LIMIT #{pageIndex},#{pageSize}")
	public List<Test> test(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

}