package org.edward.javastudy.spring.inject.lazyinit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"org/edward/javastudy/spring/inject/lazyinit/beans.xml");
		Stage stage = appContext.getBean("stage", Stage.class);
		//stage.play();

	}
}