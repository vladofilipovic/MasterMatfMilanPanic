package milan.panic.master.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Opšti način za pravljenje zastupnika zasniva se na istom principu
 * kao i prikazan AdvancedProxy mehanizam: Metod invoke interfejsa
 * InvocationHandler spona je u izvršenju metoda zastupnika i
 * originalnog objekta. On kontroliše izvršenje svih metoda zastupnika.
 */
public class JdkInvocationHandlerImpl
		implements InvocationHandler {

	Object proxiedObject;

	public JdkInvocationHandlerImpl(Object object) {
		this.proxiedObject = object;
	}

	@Override
	public Object invoke(Object classLoader, Method method,
			Object[] methodArgs) throws Throwable {
		System.out.println(
				"JDK Dynamic Proxy invoke method: Additional logic");
		return method.invoke(proxiedObject, methodArgs);
	}
}