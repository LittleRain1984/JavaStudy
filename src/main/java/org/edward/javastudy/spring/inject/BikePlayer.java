package org.edward.javastudy.spring.inject;

public class BikePlayer implements Player {
	private String name;

	private Bike bike;

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		System.out.println("Setting the Bike.");
		this.bike = bike;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Setting the name for BikePlayer");
		this.name = name;
	}

	public BikePlayer() {
		System.out.println("Invoking the constuctor BikePlayer.");
	}

	@Override
	public void perform() {
		System.out.println(name + " is playing the bike.");
	}

	private void lookupMethod() {
		System.out.println("Running the lookup method");
	}

}
