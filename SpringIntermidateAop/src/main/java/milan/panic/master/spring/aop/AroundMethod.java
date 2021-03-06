package milan.panic.master.spring.aop;

/**
 * Definicija MethodInterceptor, MethodInvocation interfejsa AOP
 * alijanse u potpunosti je analogna InvocationHandler metodu proksi
 * mehanizma, odnosno Method interfejsu mehanizma refleksije podržanom
 * od strane Java programskog jezika.
 */
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Implementacija ovog interfejsa je u stvari around savet unutar AOP
 * definicija. Ovaj savet je najopštiji i vidi se da u mnogome podseća
 * na invoke metod koji koristi zastupnik. Ponašanje ostalih
 * saveta(before, after, after throwing, after returning) moguće je
 * lako definisati od ovog najopštijeg.
 */
public class AroundMethod implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation methodInvocation)
			throws Throwable {
		try {
			Object result = methodInvocation.proceed();
			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}
}