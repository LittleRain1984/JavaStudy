package org.edward.javastudy.spring.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"org/edward/javastudy/spring/inject/beans.xml");
		// Stage stage = appContext.getBean("stage", Stage.class);
		// stage.play();

		Stage stage = appContext.getBean("stage2", Stage.class);
		// stage.play();
		System.out.println("===============");
		Player p1 = stage.lookupMethod();
		System.out.println(p1);
		Player p2 = stage.lookupMethod();
		System.out.println(p2);
	}
}