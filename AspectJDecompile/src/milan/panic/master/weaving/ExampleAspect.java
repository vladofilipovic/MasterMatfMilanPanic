/**Originalan aspekt*/
package milan.panic.master.weaving;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ExampleAspect {
	@Before("execution(* Program.method(..))")
	public void beforeExecution() {
		System.out.println("beforeExecution");
	}
	@Before("call(* Program.method(..))")
	public void beforeCall() {
		System.out.println("beforeCall");
	}
}
