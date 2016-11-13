package com.anny.study.spring.inf.dao;

import java.util.List;
import com.anny.study.spring.model.City;

public interface CityDAO {
	public List<City> queryForList(String sql);
	
	public int addCity(City city);
}
