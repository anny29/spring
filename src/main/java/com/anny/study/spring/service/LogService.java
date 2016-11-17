/**
 * 
 */
package com.anny.study.spring.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.anny.study.spring.inf.LogServiceInf;
import com.anny.study.spring.inf.dao.LogDAO;
import com.anny.study.spring.model.Log;

/**
 * @Description: TODO
 * @author: Anny
 * @time: 2016年11月14日下午4:48:11
 */
//@Service("logService")
public class LogService implements LogServiceInf {
	
	@Resource(name="transactionTemplate")
	private TransactionTemplate transactionTemplate;
	
	@Resource(name="logDAO")
	private LogDAO logDAO;
	
	@Override
	public int addLog(Log log) {
		//定义事务传播行为
		transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		return transactionTemplate.execute(new TransactionCallback<Integer>() {
			@Override
			public Integer doInTransaction(TransactionStatus status) {
				return logDAO.addLog(log);
			}
			
		});
	}

	/* (non-Javadoc)
	 * @see com.anny.study.spring.inf.LogServiceInf#deleteLog(com.anny.study.spring.model.Log)
	 */
	@Override
	public int deleteLog(Log log) {
		return logDAO.deleteLog(log);
	}
	
}
