package org.edward.javastudy.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BuilderAnimalBuildMain {
	public static void main(String[] args) throws InterruptedException {
		BuilderAnimalBuildMain main = new BuilderAnimalBuildMain();
		for (int i = 0; i < 1; i++) {
			main.test();
		}
	}

	public void test() throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<Animal>> list = new ArrayList<Future<Animal>>();

		for (int i = 0; i < 120; i++) {
			// submit Callable tasks to be executed by thread pool
			Future<Animal> future = executor.submit(new BuildAnimalCallable("name-" + i));
			// add Future to the list, we can get return value using Future
			list.add(future);
		}

		for (Future<Animal> fut : list) {
			try {
				// print the return value of Future, notice the output delay in
				// console
				// because Future.get() waits for task to get completed
				System.out.println(new Date() + "::" + fut.get().name);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		// shut down the executor service now
		executor.shutdown();
	}

}
