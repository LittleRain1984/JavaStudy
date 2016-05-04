package org.edward.javastudy.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan
public class Application {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("org/edward/javastudy/spring/ioc/beans.xml");
		MessagePrinter printer = (MessagePrinter) appContext.getBean("printer");
		printer.printMessage();
		for (String name : printer.getNames()) {
			System.out.println("name is: " + name);
		}

		System.out.println(appContext.getType("printerdd"));

	}
}