package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.dependent.PublicSchool;

public class TestSpringContainer {

	public static void main(String[] args) {
		
		/**
		 * org.springframework.context.support.ClassPathXmlApplicationContext
		 * ==> Its a class implements ApplicationContext i/f
		 * 
		 * Represents - SpringContainer started using XML based instruction, 
		 * loaded from the classpath
		 */
		try (ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("bean_config.xml")) {
			System.out.println("SC up n running !!!!!");
			
			/**
			 * How to get ready to use spring bean
			 * (class loading, init, constructor based Dependency Injection
			 * 
			 * API of :: o.s.bean.factory.BeanFactory  i/f 
			 * 
			 * public <T> T getBean(String beanId, Class<T> beanClass) throws BeansException (unchecked)
			 */
			
			PublicSchool publicSchool = ctx.getBean("public_school", PublicSchool.class);
			publicSchool.manageAcademics();
			publicSchool.organizeSportsEvent();
			
			PublicSchool publicSchool2 = ctx.getBean("public_school", PublicSchool.class);
			System.out.println(publicSchool == publicSchool2);
			
			
		} // JVM - ctx.close() -> SC invokes - destroy on singleton beans - marks GC
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
