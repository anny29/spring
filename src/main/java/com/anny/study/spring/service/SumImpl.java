/**
 * 
 */
package com.anny.study.spring.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.anny.study.spring.inf.SumInf;
import com.anny.study.spring.utils.InitSpring;

/**
 * @Description: TODO
 * @author: Anny
 * @time: 2016年9月20日下午3:04:16
 */
@Component("sumService")
public class SumImpl implements SumInf {

	private final Log logger = LogFactory.getLog(SumImpl.class);
	/* (non-Javadoc)
	 * @see com.anny.study.spring.inf.SumInf#performSum()
	 */
	@Override
	public void performSum() {
		fibnachi(1, 1);
		logger.info("performOther!!");
		performOther();
	}
	
	public void performOther() {
		int n = Integer.MIN_VALUE;
		while(n < 0) {
			n++;
		}
	}
	
	public void fibnachi(int a, int b) {
		int c = Integer.MAX_VALUE - a;
		if(b > c) {
			logger.info(a + ", " + b);
			return;
		}
		fibnachi(b, a+b);
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = InitSpring.init();
		SumImpl service =  (SumImpl) context.getBean("sumService");
		System.out.println(service.getClass().getSimpleName());
		service.performSum();
		service.performOther();
	}

}
