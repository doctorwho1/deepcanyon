package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;

import lombok.extern.slf4j.Slf4j;


public abstract class BaseMonkeyState implements MonkeyState {

	protected Monkey monkey;
	protected Rope rope;

	public BaseMonkeyState(Monkey monkey, Rope rope) {
		super();

		if (monkey == null) {
			throw new IllegalArgumentException("Monkey is a required param");
		}

		if (rope == null) {
			throw new IllegalArgumentException("Rope is a required param");
		}

		this.monkey = monkey;
		this.rope = rope;
	}

	protected boolean areSameDirectionMonkeys(Monkey firstMonkey, Monkey secondMonkey) {
		return firstMonkey.getCrossDirection().equals(secondMonkey.getCrossDirection());
	}

	public boolean isRopeFull(Rope rope) {
		return rope.getLength() == rope.getMonkeys().size();
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}