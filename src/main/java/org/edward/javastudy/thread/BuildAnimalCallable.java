package org.edward.javastudy.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

public class BuildAnimalCallable implements Callable<Animal> {

	public String animalName;
	private List<Animal> animalList;

	public BuildAnimalCallable(String animalName, List<Animal> animalList) {
		this.animalName = animalName;
		this.animalList = animalList;
	}

	public BuildAnimalCallable(String name) {
		this.animalName = name;
	}

	public void run() {

	}

	List<Animal> getAnimalList() {
		if (animalList == null) {
			animalList = new ArrayList<Animal>();
		}

		return animalList;
	}

	@Override
	public Animal call() throws Exception {
		Thread.currentThread().sleep(1000);
		if(animalName.equals("name-5")) {
			Thread.currentThread().sleep(5000);
		}
		return new Animal(animalName + "-" + new Date());
	}

}
