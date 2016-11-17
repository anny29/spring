/**
 * 
 */
package com.anny.study.spring.impl.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.anny.study.spring.inf.dao.LogDAO;
import com.anny.study.spring.model.Log;

/**
 * @Description: TODO
 * @author: Anny
 * @time: 2016年11月14日下午4:39:41
 */
@Component("logDAO")
public class LogDAOImpl implements LogDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int addLog(Log log) {
		String sql = "insert into log (info, sttm) values (?, ?)";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, log.getInfo());
				ps.setString(2, log.getSttm());
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.anny.study.spring.inf.dao.LogDAO#deleteLog(com.anny.study.spring.model.Log)
	 */
	@Override
	public int deleteLog(Log log) {
		String sql = "delete from log where id = ?";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, log.getId());
			}
		});
	}

}
