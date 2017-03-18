package milan.panic.master.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
/**
 * After savet
 */
public class AfterMethod implements AfterReturningAdvice {
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		/**
		 * After method body
		 */
	}
}