package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.dependent.PublicSchool;

public class TestSpringContainer {

	public static void main(String[] args) {
		/*
		 * org.springframework.context.support.ClassPathXmlApplicationContext
		 * => It's a class implements ApplicationContext i/f
		 * Represents - SC(spring container) started using xml based 
		 *  instructions , loaded from the classpath 
		 * 
		 */
		try (ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("bean_config.xml")) {
			System.out.println("SC up n running !!!!!");
			//invoke B.L of the public school - spring bean
			/*
			 * How to get ready to use spring bean from SC?
			 * (class loading , inst ,constr based  D.I , init)
			 * API of o.s.beans.factory.BeanFactory i.f
			 * public <T> T getBean(String beanId,Class<T> beanClass)
			 * throws BeansException
			 * BeansException : un checked exc.
			 * T - type of Spring bean
			 */
			PublicSchool school=ctx.getBean("public_school", PublicSchool.class);
			//call B.L method
			school.manageAcademics();
			school.organizeSportsEvent();
			PublicSchool school2=ctx.getBean("public_school", PublicSchool.class);
			System.out.println(school==school2);//f
		} // JVM - ctx.close() -> SC invokes - destroy on singleton beans - marks GC
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
