/**Prevedeni aspekt*/
package milan.panic.master.weaving;

import org.aspectj.lang.NoAspectBoundException;
/**
 * Aspekt se prevodi u klasu
 */
public class ExampleAspect {
	private static Throwable ajc$initFailureCause;
	public static ExampleAspect ajc$perSingletonInstance;
	/**
	 * Metod koji se koristi za dohvatanje instance aspekta
	 */
	public static ExampleAspect aspectOf() {
		if (ajc$perSingletonInstance == null) {
			throw new NoAspectBoundException(
					"milan.panic.master.weaving.ExampleAspect",
					ajc$initFailureCause);
		}
		return ajc$perSingletonInstance;
	}
	/**
	 * Metod koji provera da li aspekt postoji
	 */
	public static boolean hasAspect() {
		return ajc$perSingletonInstance != null;
	}
	/**
	 * Metod za kreiranje instance aspekta
	 */
	private static void ajc$postClinit() {
		ajc$perSingletonInstance = new ExampleAspect();
	}
	/**
	 * Statički blok u kom se kreira instanca aspekta
	 */
	static {
		try {
			ajc$postClinit();
		} catch (Throwable localThrowable) {
			ajc$initFailureCause = localThrowable;
		}
	}

	/**
	 * Metodi klase koja je prevedena od aspekta su identični savetima
	 */
	public void beforeExecution() {
		System.out.println("beforeExecution");
	}
	public void beforeCall() {
		System.out.println("beforeCall");
	}
}
