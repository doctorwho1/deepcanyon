package com.monkeys.deepcanyon.domain.state;

import org.joda.time.DateTime;
import org.joda.time.Seconds;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyFactory;
import com.monkeys.deepcanyon.domain.Rope;

public class CrossingRopeState extends BaseMonkeyState {

	public DateTime startCrossingTime = DateTime.now();

	public CrossingRopeState(Monkey monkey, Rope rope) {
		super(monkey, rope);
	}

	public MonkeyState handle() {

		MonkeyState result = this;

		if (this.isEndOfRopeReached()) {
			rope.removeMonkey(monkey);
			return MonkeyFactory.createCrossedRopeState(this.monkey);

		}

		return result;
	}

	private boolean isEndOfRopeReached() {
		return Seconds.secondsBetween(this.startCrossingTime, DateTime.now()).getSeconds() >= this.rope.getLength();
	}

}
