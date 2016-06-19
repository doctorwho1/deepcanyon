package com.monkeys.deepcanyon.domain.state;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyFactory;

public class TryingGetRopeStateTestCase extends BaseStateTestCase {

	private DateTime currentDateTime;

	@Before
	public void init() {
		this.currentDateTime = DateTime.now();
		DateTimeUtils.setCurrentMillisFixed(currentDateTime.getMillis());
	}

	@Test
	public void handleEmptyRopeEastWardDirection() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		MonkeyState monkeyState = MonkeyFactory.createTryingGetRopeState(monkey);

		DateTimeUtils.setCurrentMillisFixed(this.currentDateTime.plusSeconds(10000).getMillis());

		Assert.assertEquals(CrossingRopeState.class, monkeyState.handle().getClass());

		Assert.assertEquals(monkey, MonkeyFactory.getRopeInstance().getFirstMonkey());
	}

	@Test
	public void handleEmptyRopeWestWardDirection() {
		Monkey monkey = new Monkey(CrossDirection.WESTWARD);
		MonkeyState monkeyState = MonkeyFactory.createTryingGetRopeState(monkey);

		DateTimeUtils.setCurrentMillisFixed(this.currentDateTime.plusSeconds(10000).getMillis());

		Assert.assertEquals(CrossingRopeState.class, monkeyState.handle().getClass());

		Assert.assertEquals(monkey, MonkeyFactory.getRopeInstance().getFirstMonkey());
	}

	@Test
	public void testStartCrossingRopeRequireInSecondInTryingGetRope() {

		Monkey monkey = new Monkey(CrossDirection.EASTWARD);

		MonkeyState monkeyState = MonkeyFactory.createTryingGetRopeState(monkey);
		Assert.assertEquals(monkeyState, monkeyState.handle());

		Assert.assertEquals(TryingGetRopeState.class, monkeyState.handle().getClass());

		DateTimeUtils.setCurrentMillisFixed(this.currentDateTime.plusSeconds(10000).getMillis());

		MonkeyState newState = monkeyState.handle();
		Assert.assertEquals(CrossingRopeState.class, newState.getClass());

	}

}
