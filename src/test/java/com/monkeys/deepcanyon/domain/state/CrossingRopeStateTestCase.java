package com.monkeys.deepcanyon.domain.state;

import org.junit.Assert;
import org.junit.Test;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;
import com.monkeys.deepcanyon.util.TestUtil;

public class CrossingRopeStateTestCase {

	@Test
	public void handleCrossRopeEastWardDirection() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		Rope rope = TestUtil.createEmptyRope();
		
		int firstPosition = rope.getEastwardFirstPosition();
		rope.putMonkey(firstPosition, monkey);

		 MonkeyState monkeyState = MonkeyStateFactory.createCrossingRopeState(firstPosition);
		
		for (int i=0; i < rope.getLength(); i++){
			Assert.assertEquals(CrossingRopeState.class, monkeyState.getClass());
			Assert.assertEquals(firstPosition + i, ((CrossingRopeState)monkeyState).getCurrentRopePosition());
			monkeyState = monkeyState.handle(monkey, rope);
			
		}
		
		Assert.assertEquals(CrossedRopeState.class, monkeyState.getClass());
	}
	
	@Test
	public void handleCrossRopeWestWardDirection() {
		Monkey monkey = new Monkey(CrossDirection.WESTWARD);
		Rope rope = TestUtil.createEmptyRope();
		
		int firstPosition = rope.getWestwardFirstPosition();
		rope.putMonkey(firstPosition, monkey);

		 MonkeyState monkeyState = MonkeyStateFactory.createCrossingRopeState(firstPosition);
		
		for (int i=0; i < rope.getLength(); i++){
			Assert.assertEquals(CrossingRopeState.class, monkeyState.getClass());
			Assert.assertEquals(firstPosition - i, ((CrossingRopeState)monkeyState).getCurrentRopePosition());
			monkeyState = monkeyState.handle(monkey, rope);
			
		}
		
		Assert.assertEquals(CrossedRopeState.class, monkeyState.getClass());
	}

}
