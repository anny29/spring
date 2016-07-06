package com.anny.study.spring.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitSpring {
	public static ClassPathXmlApplicationContext init() {
		Log log = LogFactory.getLog(InitSpring.class);
		log.info("--开始初始化Spring容器--");
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("application-context.xml");
		log.info("--初始化Spring容器完成--");
		return applicationContext;
	}
}
