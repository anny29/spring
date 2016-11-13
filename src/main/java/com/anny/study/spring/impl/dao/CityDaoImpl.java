package com.anny.study.spring.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.anny.study.spring.inf.dao.CityDAO;
import com.anny.study.spring.model.City;

@Component("cityDAO")
public class CityDaoImpl implements CityDAO {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<City> queryForList(String sql) {
		List<City> results = new ArrayList<City>();
		if(StringUtils.isNotEmpty(sql)) {
			results = jdbcTemplate.query(sql, new RowMapper<City>() {

				@Override
				public City mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					City city = new City();
					city.setCityName(rs.getString("CITY_NAME"));
					city.setProvinceName(rs.getString("PROVINCE_NAME"));
					return city;
				}
				
			});
		}
		return results;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addCity(final City city) {
	/*	if(city != null && StringUtils.isNotBlank(city.getCityName()) &&  StringUtils.isNotBlank(city.getProvinceName())) {
		}*/
		String sql = "insert into city (city_name, province_name) values (?, ?)";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, city.getCityName());
				ps.setString(2, city.getProvinceName());
			}
		});
	}

	@Override
	public int deleteCity(City city) {
		String sql = "delete from city where city_name = ?";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, city.getCityName());
			}
		});
	}
	
	
}