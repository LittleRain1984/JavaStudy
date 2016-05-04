package org.edward.javastudy.spring.ioc;

public class MessagePrinter {

	private MessageService s1;

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	private String[] names;

	public void setService(MessageService service) {
		this.s1 = service;
	}

	public MessagePrinter() {
	}

	public void printMessage() {
		System.out.println(this.s1.getMessage());
	}

	private void sayGoodBye() {
		System.out.println(this.getClass().getCanonicalName() + " saying good bye.");
	}
}
