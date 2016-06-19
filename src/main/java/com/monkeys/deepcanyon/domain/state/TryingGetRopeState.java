package com.monkeys.deepcanyon.domain.state;

import org.joda.time.DateTime;
import org.joda.time.Seconds;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyFactory;
import com.monkeys.deepcanyon.domain.Rope;

public class TryingGetRopeState extends BaseMonkeyState {

	private DateTime initStateTime = DateTime.now();

	public TryingGetRopeState(Monkey monkey, Rope rope) {
		super(monkey, rope);
	}

	public MonkeyState handle() {

		MonkeyState result = this;
		Monkey firstMonkey = this.rope.getFirstMonkey();

		if (this.isElapsedOneSecond() && (firstMonkey == null || this.areSameDirectionMonkeys(monkey, firstMonkey))) {

			// TODO: ¿Mover a la factoría la introducción del mono en la cuerda?
			rope.addMonkey(monkey);
			result = MonkeyFactory.createCrossingRopeState(this.monkey);
		}

		return result;

	}

	private boolean isElapsedOneSecond() {
		return Seconds.secondsBetween(this.initStateTime, DateTime.now()).getSeconds() >= 1;
	}

}
