package com.monkeys.deepcanyon.domain.state;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;
import com.monkeys.deepcanyon.util.TestUtil;

public class CrossingRopeStateTestCase {

	@Before
	public void setUp() {
		MonkeyFactory.getRopeInstance().reset();
	}

	@Test
	public void handleCrossRopeEastWardDirection() {
		Monkey monkey = TestUtil.createEastwardMonkey();
		Rope rope = TestUtil.createEmptyRope();

		int firstPosition = rope.getEastwardFirstPosition();
		rope.putMonkey(firstPosition, monkey);

		MonkeyState monkeyState = MonkeyFactory.createCrossingRopeState(monkey, firstPosition);

		for (int i = 0; i < rope.getLength(); i++) {
			Assert.assertEquals(CrossingRopeState.class, monkeyState.getClass());
			Assert.assertEquals(firstPosition + i, ((CrossingRopeState) monkeyState).getCurrentRopePosition());
			monkeyState = monkeyState.handle();

		}

		Assert.assertEquals(CrossedRopeState.class, monkeyState.getClass());
	}

	@Test
	public void handleCrossRopeWestWardDirection() {
		Monkey monkey = TestUtil.createWestwardMonkey();
		Rope rope = TestUtil.createEmptyRope();

		int firstPosition = rope.getWestwardFirstPosition();
		rope.putMonkey(firstPosition, monkey);

		MonkeyState monkeyState = MonkeyFactory.createCrossingRopeState(monkey, firstPosition);

		for (int i = 0; i < rope.getLength(); i++) {
			Assert.assertEquals(CrossingRopeState.class, monkeyState.getClass());
			Assert.assertEquals(firstPosition - i, ((CrossingRopeState) monkeyState).getCurrentRopePosition());
			monkeyState = monkeyState.handle();

		}

		Assert.assertEquals(CrossedRopeState.class, monkeyState.getClass());
	}

	@Test
	public void handleCrossRopeEastWardDirectionCanNotAdvanceMonkeyInNextPosition() {
		Monkey monkey = TestUtil.createEastwardMonkey();
		Monkey frontMonkey = TestUtil.createEastwardMonkey();
		Rope rope = TestUtil.createEmptyRope();

		int firstPosition = rope.getEastwardFirstPosition();
		rope.putMonkey(firstPosition, monkey);
		rope.putMonkey(firstPosition + 1, frontMonkey);

		MonkeyState monkeyState = MonkeyFactory.createCrossingRopeState(monkey, firstPosition);

		Assert.assertEquals(firstPosition, ((CrossingRopeState) monkeyState).getCurrentRopePosition());
		monkeyState = monkeyState.handle();

		// Not advance any position. Is in same position
		Assert.assertEquals(CrossingRopeState.class, monkeyState.getClass());
		Assert.assertEquals(firstPosition, ((CrossingRopeState) monkeyState).getCurrentRopePosition());

	}

}
