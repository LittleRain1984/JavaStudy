package org.edward.javastudy.spring.inject;

public class MotoPlayer implements Player {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MotoPlayer() {
		System.out.println("Invoking the constuctor MotoPlayer.");
	}

	@Override
	public void perform() {
		System.out.println(name + " is playing the Moto.");
	}

}
