package be.pxl.ja.executor;

import java.util.Random;
import java.util.concurrent.*;

public class GeneratingFutureString {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		//dit stelt een zware functie voor die lang duurt
		Callable<String> generateRandomLetters = () -> {
			int leftLimit = 'a'; // letter 'a'
			int rightLimit = 'z'; // letter 'z'
			int targetStringLength = 10;
			Random random = new Random();
			StringBuilder buffer = new StringBuilder(targetStringLength);
			for (int i = 0; i < targetStringLength; i++) {
				int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
				buffer.append((char) randomLimitedInt);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return buffer.toString();
		};
		// future is een object dat een resultaat zal bevatten van een asynchrone taak
		//future wijst op het toekomstig resultaat van de zware functie
		Future<String> result = executorService.submit(generateRandomLetters);


		System.out.println("Counting down...");
		for (int i = 10; i >= 0; i--) {
			System.out.println(i);
		}
		//future.isDone() geeft true terug als de taak voltooid is
		if (result.isDone()) {
			System.out.println("generating letters is done.");
		} else {
			System.out.println("generating letters is running.");
		}
        try {
			//future.get() geeft het resultaat van de taak terug
			//als het resultaat er nog niet is, blijft het wachten tot het resultaat er is
			// == promise
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
	}

}