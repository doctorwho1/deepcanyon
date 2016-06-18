package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;

public class TryingGetRopeState extends BaseMonkeyState {

	public MonkeyState handle(Monkey monkey, Rope rope) {

		int currentMonkeyPosition;
		switch (monkey.getCrossDirection()) {
		case EASTWARD:
			currentMonkeyPosition = rope.getEastwardFirstPosition();
			break;
		case WESTWARD:
			currentMonkeyPosition = rope.getWestwardFirstPosition();
			break;
		default:
			throw new IllegalStateException("Monkey should have a cross direction");
		}
		
		rope.putMonkey(currentMonkeyPosition, monkey);
		return MonkeyStateFactory.createCrossingRopeState(currentMonkeyPosition);
	}

}
