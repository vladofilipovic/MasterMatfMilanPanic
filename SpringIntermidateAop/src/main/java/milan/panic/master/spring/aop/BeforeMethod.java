package milan.panic.master.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
/**
 * Before savet
 */
public class BeforeMethod implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		/**
		 * Before method body
		 */
	}
}