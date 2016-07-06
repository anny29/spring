package com.anny.study.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.anny.study.spring.inf.dao.CityDAO;
import com.anny.study.spring.model.City;
import com.anny.study.spring.utils.InitSpring;

@Service("cityService")
public class CityService {
	
	@Resource(name="cityDAO")
	private CityDAO cityDao;
	
	public void printAllCitys() {
		String sql = "select * from city";
		List<City> list = cityDao.queryForList(sql);
		for(City city : list) {
			System.out.println(city.getProvinceName() + " " + city.getCityName());
		}
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = InitSpring.init();
		CityService service =  (CityService) context.getBean("cityService");
		service.printAllCitys();
	}

}
