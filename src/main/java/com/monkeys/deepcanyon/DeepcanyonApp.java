package com.monkeys.deepcanyon;

import java.util.Random;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;

public class DeepcanyonApp {
	
	private static final int MAX_NUMBER_INITIAL_MONKEYS = 4;
	private static final int MAX_INTERVAL_ARRIVAL_MONKEYS = 8;

	private final Random random = new Random();

	public static void main(String[] args) throws InterruptedException {
		DeepcanyonApp app = new DeepcanyonApp();
		app.run();

	}

	private void run() throws InterruptedException {

		this.createRandonNumberOfInitialMonkeys();

		while (true) {
			Thread.sleep(this.generateRandomMonkeyWaitArrival());
			this.wrapMonkeyInThread();
		}

	}

	private void createRandonNumberOfInitialMonkeys() {
		int numberOfInitialMonkeys = random.nextInt(DeepcanyonApp.MAX_NUMBER_INITIAL_MONKEYS);
		for (int i = 0; i < numberOfInitialMonkeys; i++) {
			this.wrapMonkeyInThread();
		}
	}

	private void wrapMonkeyInThread() {
		new Thread(new MonkeyRunnable(this.generateRandomMonkey())).start();
	}

	private long generateRandomMonkeyWaitArrival() {
		int seconds = random.nextInt(DeepcanyonApp.MAX_INTERVAL_ARRIVAL_MONKEYS) + 1;

		return 1000 * seconds;
	}

	private Monkey generateRandomMonkey() {
		return new Monkey(CrossDirection.values()[random.nextInt(CrossDirection.values().length)]);
	}

}
