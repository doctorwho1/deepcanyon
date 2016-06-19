package com.monkeys.deepcanyon;

import java.util.Random;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;


public class DeepcanyonApp {

	private final Random random = new Random();

	public static void main(String[] args) throws InterruptedException {
		DeepcanyonApp app = new DeepcanyonApp();
		app.run();

	}

	private void run() throws InterruptedException {

		while(true){
			Thread.sleep(this.generateRandomMonkeyWaitArrival());
			this.wrapMonkeyInThread();
		}
		
		
	}
	
	private void wrapMonkeyInThread(){
		new Thread(new MonkeyRunnable(this.generateRandomMonkey())).start();
	}
	
	private long generateRandomMonkeyWaitArrival(){
		int seconds = random.nextInt(8) + 1;
		
		return 1000*seconds;
	}

	private Monkey generateRandomMonkey() {
		return new Monkey(CrossDirection.values()[random.nextInt(2)]);
	}

}
