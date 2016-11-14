/**
 * 
 */
package com.anny.study.spring.aop;

import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @author: Anny
 * @time: 2016年9月20日下午2:21:05
 */
@Component("stopWatchAspect")
@Aspect
public class StopWatchAspect {
	
	private final Log logger = LogFactory.getLog(StopWatchAspect.class); 
	
	@Pointcut("execution(public * com.anny.study.spring.service..*.perform*(..))") 
	public void pointCutName() {}
	
	@Around("pointCutName()")
	public Object performenceTrace(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch watch = new StopWatch();
		try {
			watch.start();
			return joinPoint.proceed();
		} finally {
			watch.stop();
			logger.info(joinPoint.getSignature() + "，耗时：" + watch.toString());
		}
	}
}
