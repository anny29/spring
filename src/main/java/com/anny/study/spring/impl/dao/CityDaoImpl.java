package com.anny.study.spring.impl.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.anny.study.spring.inf.dao.CityDAO;
import com.anny.study.spring.model.City;

public class CityDaoImpl implements CityDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<City> queryForList(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

}
