package com.anny.study.spring.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.anny.study.spring.inf.LogServiceInf;
import com.anny.study.spring.inf.dao.CityDAO;
import com.anny.study.spring.model.City;
import com.anny.study.spring.utils.InitSpring;

@Service("cityService")
public class CityService {
	
	private final Log log = LogFactory.getLog(CityService.class);
	
	@Resource(name="cityDAO")
	private CityDAO cityDao;
	@Resource(name="transactionManager")
	private PlatformTransactionManager transactionManager;
	@Resource(name="logService")
	private LogServiceInf logService;
	
	public void printAllCitys() {
		String sql = "select * from city";
		List<City> list = cityDao.queryForList(sql);
		for(City city : list) {
			System.out.println(city.getProvinceName() + " " + city.getCityName());
		}
	}
	
	public void addCity(City city) {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setTimeout(20);
		TransactionStatus txStatus = transactionManager.getTransaction(definition);
		try {
			cityDao.addCity(city);
		}  catch(RuntimeException re) {
			log.error("新增失败!", re);
			transactionManager.rollback(txStatus);
			throw re;
		}
		logService.addLog(
				new com.anny.study.spring.model.Log("城市" + city.getCityName() + "新增成功！", 
						DateFormatUtils.format(new Date(), "yyyy-MM-dd")));
		transactionManager.commit(txStatus);
	}
	
	public void deleteCity(City city) {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setTimeout(20);
		TransactionStatus txStatus = transactionManager.getTransaction(definition);
		try {
			cityDao.deleteCity(city);
		}  catch(RuntimeException re) {
			log.error("新增失败!", re);
			transactionManager.rollback(txStatus);
			throw re;
		}
		transactionManager.commit(txStatus);
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = InitSpring.init();
		CityService service =  (CityService) context.getBean("cityService");
		service.addCity(new City("荆门", "湖北"));
		//service.deleteCity(new City("襄阳", "湖北"));
		service.printAllCitys();
	}

}