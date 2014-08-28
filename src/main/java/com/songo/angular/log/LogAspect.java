/**
 * 
 */
package com.songo.angular.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>decription:</p>
 * <p>date:2014年7月11日 下午2:28:52</p>
 * @author gsu·napoleon
 */
@Component
@Aspect
public class LogAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Pointcut("execution(* com.songo.angular.service.*.save*(..)) || " +
			"execution(* com.songo.angular.service.*.add*(..))")
	public void saveServiceCall() { }

	@Pointcut("execution(* com.songo.angular.service.*.update*(..))")
	public void updateServiceCall() { }
	
	@Pointcut("execution(* com.songo.angular.service.*.del*(..)) || " +
			"execution(* com.songo.angular.service.*.remove*(..))")
	public void removeServiceCall() { }
	
	@Pointcut("execution(* com.songo.angular.service.*.select*(..)) || " +
			"execution(* com.songo.angular.service.*.query*(..)) || " +
			"execution(* com.songo.angular.service.*.get*(..)) || " + 
			"execution(* com.songo.angular.service.*.find*(..))")
	public void queryServiceCall() { }
	
	@AfterReturning(value="saveServiceCall()", argNames="rtv", returning="rtv")
	public void saveServiceCallbacks(JoinPoint point, Object rtv) throws Throwable {
		
		if (point.getArgs() == null) {
			return;
		}
		
		String operator = "还珠楼主";
		String className = point.getSignature().getDeclaringTypeName();
		String methodName = point.getSignature().getName();
		String operatorContent = "数据添加";
		
		
		logger.info("操作人：" + operator + "; 操作类：" + className + "; 操作方法：" + methodName + "; 操作内容：" + operatorContent);
		
	}
}
