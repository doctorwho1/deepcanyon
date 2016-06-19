package com.monkeys.deepcanyon;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.state.BaseMonkeyState;
import com.monkeys.deepcanyon.domain.state.CrossedRopeState;
import com.monkeys.deepcanyon.domain.state.MonkeyState;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MonkeyRunnable implements Runnable {

	private Monkey monkey;

	public MonkeyRunnable(Monkey monkey) {
		super();
		this.monkey = monkey;
	}

	public void run() {
		while (true) {
			MonkeyState previousState = this.monkey.getState();
			this.monkey.think();

			if (!this.monkey.getState().equals(previousState)) {
				log.info(this.monkey.toString());
			}

			if (!(this.monkey.getState() instanceof CrossedRopeState)) {
				Thread.currentThread().interrupt();

			}

		}

	}

}
