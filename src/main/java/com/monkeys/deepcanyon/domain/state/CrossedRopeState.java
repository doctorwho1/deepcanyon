package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;

public class CrossedRopeState extends BaseMonkeyState {

	public CrossedRopeState(Monkey monkey, Rope rope) {
		super(monkey, rope);
	}

	public MonkeyState handle() {

		return this;
	}

}
