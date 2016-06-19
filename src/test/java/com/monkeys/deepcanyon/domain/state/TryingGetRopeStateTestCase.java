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

public class TryingGetRopeStateTestCase extends BaseStateTestCase {


	private DateTime currentDateTime;
	
	@Before
	public void init(){
		this.currentDateTime = DateTime.now();
		DateTimeUtils.setCurrentMillisFixed(this.currentDateTime.getMillis());
	}
	
	@Test
	public void handleEmptyRopeEastWardDirection() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		MonkeyState newState = MonkeyFactory.createTryingGetRopeState(monkey).handle();

		Assert.assertEquals(CrossingRopeState.class, newState.getClass());

		// TODO: Comprobar que el mono ahora ocupa la primera posición de la
		// cuerda.
	}

	@Test
	public void handleEmptyRopeWestWardDirection() {
		Monkey monkey = new Monkey(CrossDirection.WESTWARD);
		MonkeyState newState = MonkeyFactory.createTryingGetRopeState(monkey).handle();

		Assert.assertEquals(CrossingRopeState.class, newState.getClass());

		// TODO: Comprobar que el mono ahora ocupa la primera posición de la
		// cuerda.
	}

	@Test
	public void handleEastWardMonkeysInOppositeDirection() {
		Monkey monkey = new Monkey(CrossDirection.WESTWARD);
		Rope rope = TestUtil.createEmptyRope();
		rope.addMonkey(Monkey.builder().crossDirection(CrossDirection.EASTWARD).build());

		MonkeyState newState = MonkeyFactory.createTryingGetRopeState(monkey).handle();

		Assert.assertEquals(WaitingInQueueState.class, newState.getClass());

		// TODO: Comprobar que el mono regresa a la primera posición de la cola.
	}

	@Test
	public void handleWestWardMonkeysInOppositeDirection() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		Rope rope = TestUtil.createEmptyRope();
		rope.addMonkey(Monkey.builder().crossDirection(CrossDirection.WESTWARD).build());

		MonkeyState newState = MonkeyFactory.createTryingGetRopeState(monkey).handle();

		Assert.assertEquals(WaitingInQueueState.class, newState.getClass());

		// TODO: Comprobar que el mono regresa a la primera posición de la cola.
	}
	
	@Test
	public void testStartCrossingRopeRequireInSecondInTryingGetRope(){
		
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		Rope rope = TestUtil.createEmptyRope();
		rope.addMonkey(Monkey.builder().crossDirection(CrossDirection.WESTWARD).build());

		MonkeyState monkeyState = MonkeyFactory.createTryingGetRopeState(monkey);
		
		
		Assert.assertEquals(monkeyState, monkeyState.handle());
		DateTimeUtils.setCurrentMillisFixed(this.currentDateTime.plusSeconds(1).getMillis());
		Assert.assertEquals(WaitingInQueueState.class, monkeyState.handle());
		
		MonkeyState newState = monkeyState.handle();
		Assert.assertEquals(WaitingInQueueState.class, newState.getClass());
		
	}

}
