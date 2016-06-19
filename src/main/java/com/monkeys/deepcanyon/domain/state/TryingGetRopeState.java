package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyFactory;
import com.monkeys.deepcanyon.domain.Rope;

public class TryingGetRopeState extends BaseMonkeyState {

	public TryingGetRopeState(Monkey monkey, Rope rope) {
		super(monkey, rope);
	}

	public MonkeyState handle() {
		
		Monkey firstMonkey = this.rope.getFirstMonkey();

		if (firstMonkey == null
				|| this.areSameDirectionMonkeys(monkey, firstMonkey)) {


			// TODO: ¿Mover a la factoría la introducción del mono en la cuerda?
			rope.addMonkey(monkey);
			return MonkeyFactory.createCrossingRopeState(this.monkey);
		} else {
			// Can not get rope, monkeys in opposite direction.
			return MonkeyFactory.createWaitingInQueueState(monkey);
		}
	}

}
