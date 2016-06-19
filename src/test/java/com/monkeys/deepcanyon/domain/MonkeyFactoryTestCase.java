package com.monkeys.deepcanyon.domain;

import org.junit.Assert;
import org.junit.Test;

import com.monkeys.deepcanyon.domain.state.WaitingInQueueState;

public class MonkeyFactoryTestCase {

	@Test
	public void testCreateWaitingInEastwardQueueState() {

		WaitingInQueueState state = MonkeyFactory
				.createWaitingInQueueState(Monkey.builder().crossDirection(CrossDirection.EASTWARD).build());

		Assert.assertEquals(CrossDirection.EASTWARD, state.getMonkeyQueue().getCrossDirection());

	}

	@Test
	public void testCreateWaitingInWestwardQueueState() {

		WaitingInQueueState state = MonkeyFactory
				.createWaitingInQueueState(Monkey.builder().crossDirection(CrossDirection.WESTWARD).build());

		Assert.assertEquals(CrossDirection.WESTWARD, state.getMonkeyQueue().getCrossDirection());

	}
}
