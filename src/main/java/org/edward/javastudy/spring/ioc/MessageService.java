package org.edward.javastudy.spring.ioc;

import javax.annotation.PostConstruct;

public interface MessageService {
	String getMessage();
}

class MessageServiceImpl implements MessageService {

	@Override
	public String getMessage() {
		return "Hello World!";
	}
	
	@PostConstruct
	private void sayHi() {
		System.out.println(this.getClass().getCanonicalName() + " saying hi.");
	}
	
	private void sayGoodBye() {
		System.out.println(this.getClass().getCanonicalName() + " saying good bye.");
	}
}