package com.monkeys.deepcanyon.domain.state;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyFactory;
import com.monkeys.deepcanyon.domain.Rope;
import com.monkeys.deepcanyon.util.TestUtil;

public class CrossingRopeStateTestCase extends BaseStateTestCase {


	@After
	public void tearDown() {
		DateTimeUtils.setCurrentMillisSystem();
	}

	@Test
	public void handleCrossRopeEastWardDirection() {
		Monkey monkey = TestUtil.createEastwardMonkey();
		Rope rope = TestUtil.createEmptyRope();
		DateTime currentTime = DateTime.now();

		rope.addMonkey(monkey);

		DateTimeUtils.setCurrentMillisFixed(currentTime.getMillis());
		MonkeyState monkeyState = MonkeyFactory.createCrossingRopeState(monkey);

		for (int i = 1; i <= rope.getLength(); i++) {
			Assert.assertEquals(monkeyState, monkeyState);
			DateTimeUtils.setCurrentMillisFixed(currentTime.plusSeconds(i).getMillis());
			monkeyState = monkeyState.handle();
		}

		Assert.assertEquals(CrossedRopeState.class, monkeyState.getClass());
	}

}
