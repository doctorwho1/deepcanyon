package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;

public class TryingGetRopeState extends BaseMonkeyState {

	public MonkeyState handle(Monkey monkey, Rope rope) {

		rope.addMonkey(monkey);

		return MonkeyStateFactory.createCrossingRopeState();
	}

}
