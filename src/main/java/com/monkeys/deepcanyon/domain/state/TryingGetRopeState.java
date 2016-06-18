package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;

public class TryingGetRopeState implements MonkeyState {

	public MonkeyState handle(Monkey monkey, Rope rope) {

		rope.addMonkey(monkey);

		return MonkeyStates.CROSSING_ROPE;
	}

}
