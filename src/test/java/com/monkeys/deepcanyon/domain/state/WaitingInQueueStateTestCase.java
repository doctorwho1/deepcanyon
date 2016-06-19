package com.monkeys.deepcanyon.domain.state;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyFactory;
import com.monkeys.deepcanyon.domain.Rope;
import com.monkeys.deepcanyon.util.TestUtil;

public class WaitingInQueueStateTestCase extends BaseStateTestCase {
	
	private DateTime currentDateTime;

	@Before
	public void init() {
		this.currentDateTime = DateTime.now();
		DateTimeUtils.setCurrentMillisFixed(currentDateTime.getMillis());
	}

	@Test
	public void handleEmptyRope() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		MonkeyState newState = MonkeyFactory.createWaitingInQueueState(monkey).handle();

		Assert.assertEquals(TryingGetRopeState.class, newState.getClass());
	}

	
	
	@Test
	public void eastwardMonkeyRopeWithMonkeyInSameDirectionAndMonkeyWaitingInOppositeDirection() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		Rope rope = TestUtil.createEmptyRope();
		rope.addMonkey(Monkey.builder().crossDirection(CrossDirection.EASTWARD).build());
		MonkeyFactory.getWestwardqueue().addMonkey(Monkey.builder().crossDirection(CrossDirection.WESTWARD).build());
		
		MonkeyState newState = MonkeyFactory.createWaitingInQueueState(monkey).handle();
		

		Assert.assertEquals(GivingWayState.class, newState.getClass());

	}
	
	@Test
	public void westwardMonkeyRopeWithMonkeyInSameDirectionAndMonkeyWaitingInOppositeDirection() {
		Monkey monkey = new Monkey(CrossDirection.WESTWARD);
		Rope rope = TestUtil.createEmptyRope();
		rope.addMonkey(Monkey.builder().crossDirection(CrossDirection.WESTWARD).build());
		MonkeyFactory.getWestwardqueue().addMonkey(Monkey.builder().crossDirection(CrossDirection.EASTWARD).build());
		
		MonkeyState newState = MonkeyFactory.createWaitingInQueueState(monkey).handle();
		

		Assert.assertEquals(GivingWayState.class, newState.getClass());

	}


	@Test
	public void monkeyCanNotChangeStateBecauseIsNotFirstMonkeyInQueue() {
		Monkey firtMonkey = new Monkey(CrossDirection.EASTWARD);
		Monkey secondMonkey = new Monkey(CrossDirection.EASTWARD);

		MonkeyFactory.getEastwardqueue().addMonkey(firtMonkey);
		MonkeyFactory.getEastwardqueue().addMonkey(secondMonkey);

		Assert.assertEquals(WaitingInQueueState.class, firtMonkey.getState().getClass());

		// State not change.
		Assert.assertEquals(secondMonkey.getState(), secondMonkey.getState().handle());

		
		// Now first monkey advance.
		firtMonkey.think();
		Assert.assertEquals(TryingGetRopeState.class, firtMonkey.getState().getClass());
		DateTimeUtils.setCurrentMillisFixed(this.currentDateTime.plusSeconds(10).getMillis());
		firtMonkey.think();
		Assert.assertEquals(CrossingRopeState.class, firtMonkey.getState().getClass());
		
		// Now second monkey can advance
		Assert.assertEquals(TryingGetRopeState.class, secondMonkey.getState().handle().getClass());

	}
	
	@Test
	public void twoCompetingMonkeysOnlyOneGetTheRope(){
		MonkeyState firstMonkeyState = MonkeyFactory.createWaitingInQueueState( new Monkey(CrossDirection.EASTWARD));
		MonkeyState secondMonkeyState = MonkeyFactory.createWaitingInQueueState( new Monkey(CrossDirection.WESTWARD));
		
		Assert.assertEquals(TryingGetRopeState.class, secondMonkeyState.handle().getClass());
		Assert.assertEquals(firstMonkeyState, firstMonkeyState.handle());
		Assert.assertEquals(WaitingInQueueState.class, firstMonkeyState.handle().getClass());
	}

}
