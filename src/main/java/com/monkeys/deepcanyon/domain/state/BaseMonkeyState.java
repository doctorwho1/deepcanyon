package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;

public abstract class BaseMonkeyState  implements MonkeyState {

	public BaseMonkeyState() {
		super();
	}
	
	protected boolean areSameDirectionMonkeys(Monkey firstMonkey, Monkey secondMonkey) {
		return firstMonkey.getCrossDirection().equals(secondMonkey.getCrossDirection());
	}

	public boolean isRopeFull(Rope rope) {
		return rope.getLength() == rope.getMonkeys().size();
	}

}