package spring.aop.anno;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAdvice {
	private Log log = LogFactory.getLog(getClass());
	
	public void logPush(ProceedingJoinPoint pjp) throws Throwable {
		log.info("check...before logging...");
		
		Object ret=pjp.proceed(); // target으로 위빙되는 시점
		System.out.println("target method return..."+ret);
		
		log.info("check...after logging...");
	}
}
