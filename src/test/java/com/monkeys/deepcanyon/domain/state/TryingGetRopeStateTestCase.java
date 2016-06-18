package com.monkeys.deepcanyon.domain.state;

import org.junit.Assert;
import org.junit.Test;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;
import com.monkeys.deepcanyon.util.TestUtil;

public class TryingGetRopeStateTestCase {

	@Test
	public void handleEmptyRopeEastWardDirection() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		MonkeyState newState = MonkeyStateFactory.createTryingGetRopeState().handle(monkey, TestUtil.createEmptyRope());

		Assert.assertEquals(CrossingRopeState.class, newState.getClass());

		// TODO: Comprobar que el mono ahora ocupa la primera posición de la
		// cuerda.
	}

	@Test
	public void handleEmptyRopeWestWardDirection() {
		Monkey monkey = new Monkey(CrossDirection.WESTWARD);
		MonkeyState newState = MonkeyStateFactory.createTryingGetRopeState().handle(monkey, TestUtil.createEmptyRope());

		Assert.assertEquals(CrossingRopeState.class, newState.getClass());

		// TODO: Comprobar que el mono ahora ocupa la primera posición de la
		// cuerda.
	}

	@Test
	public void handleEastWardMonkeysInOppositeDirection() {
		Monkey monkey = new Monkey(CrossDirection.WESTWARD);
		Rope rope = TestUtil.createEmptyRope();
		rope.addMonkey(Monkey.builder().crossDirection(CrossDirection.EASTWARD).build());

		MonkeyState newState = MonkeyStateFactory.createTryingGetRopeState().handle(monkey, rope);

		Assert.assertEquals(WaitingInQueueState.class, newState.getClass());

		// TODO: Comprobar que el mono regresa a la primera posición de la cola.
	}

	@Test
	public void handleWestWardMonkeysInOppositeDirection() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		Rope rope = TestUtil.createEmptyRope();
		rope.addMonkey(Monkey.builder().crossDirection(CrossDirection.WESTWARD).build());

		MonkeyState newState = MonkeyStateFactory.createTryingGetRopeState().handle(monkey, rope);

		Assert.assertEquals(WaitingInQueueState.class, newState.getClass());

		// TODO: Comprobar que el mono regresa a la primera posición de la cola.
	}

}
