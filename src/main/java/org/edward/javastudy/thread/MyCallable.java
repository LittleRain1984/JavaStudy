package org.edward.javastudy.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<String> {

	public String name;

	MyCallable(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(5000);
//		if (name.equals("mc-5") || name.equals("mc2-10")) {
//			Thread.sleep(1000);
//		}
		// return the thread name executing this callable task
		return Thread.currentThread().getName() + "++>" + this.name;
	}

	public static void main(String args[]) throws InterruptedException {
		// Get ExecutorService from Executors utility class, thread pool size is
		// 10
		ExecutorService executor = Executors.newFixedThreadPool(100);
		ExecutorService executor2 = Executors.newFixedThreadPool(100);
		// create a list to hold the Future object associated with Callable
		List<Future<String>> list = new ArrayList<Future<String>>();
		// Create MyCallable instance
		for (int i = 0; i < 100; i++) {
			// submit Callable tasks to be executed by thread pool
			Future<String> future = executor.submit(new MyCallable("mc-" + i));
			Future<String> future2 = executor2.submit(new MyCallable("mc2-" + i));

			// add Future to the list, we can get return value using Future
			list.add(future2);
			list.add(future);

		}

		//Thread.sleep(10000);

		for (int i = 0; i < list.size(); i++)

		{
			try {
				// print the return value of Future, notice the output delay in
				// console
				// because Future.get() waits for task to get completed
				System.out.println(i + "==>" + new Date() + "::" + list.get(i).get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		// shut down the executor service now
		executor.shutdown();
		executor2.shutdown();
	}

}
