package milan.panic.master.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Primer korišćenja osnovnog Spring aspektno orijentisanog sistema.
 */
public class SpringProgram {
	static ApplicationContext springContainer;

	public static void main(String[] args) {
		springContainer = new ClassPathXmlApplicationContext(
				"spring-intermidate-aop.xml");
		/**
		 * Direktno se mora dohvatiti proksi objekat za dalje korišćenje
		 */
		Service service = (Service) springContainer.getBean("serviceProxy");
		service.serviceMethod();
	}

}