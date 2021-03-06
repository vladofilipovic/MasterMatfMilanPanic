package milan.panic.master.proxy;

import java.lang.reflect.Method;

/**
 * Napredna implementacija zastupnika moze da uz pomoć refleksije
 * uključi univerzalnog rukovaoca metodima koji su definisani u
 * interfejsu koji se zastupa. Ipak, uz pomoć refleksije nije moguće
 * dinamički dodeliti interfejs nekom objektu, tako da definicija
 * interfejsa i eksplicitna implementacija svih metoda zastupanog
 * interfejsa ostaje unutar ovako napravljenog zastupnika.
 */
public class AdvancedProxy implements Interface {

	Interface interfaceInstance;
	ProxyHandler proxyHandler;

	public AdvancedProxy(Interface interfaceInstance,
			ProxyHandler proxyHandler) {
		this.interfaceInstance = interfaceInstance;
		this.proxyHandler = proxyHandler;
	}

	/**
	 * Univerzalniji način zastupanja originalnog metoda. Telo svakog
	 * metoda koji se zastupa u zastupaocu biće identično: metod i
	 * parametri metoda se proseđuju interfejsu ProxyHandler koji će
	 * se izvršiti umesto njega i ukoliko je potrebno pozvati
	 * originalni metod zastupanog objekta.
	 */
	@Override
	public Object method() {
		try {
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			Method method = interfaceInstance.getClass()
					.getMethod(methodName, null);
			return proxyHandler.invoke(interfaceInstance, method,
					null);
		} catch (SecurityException e) {
			// Obrada sigurnosnog izuzetka.
		} catch (Throwable e) {
			// Obrada throwable.
		}
		return null;
	}
}
