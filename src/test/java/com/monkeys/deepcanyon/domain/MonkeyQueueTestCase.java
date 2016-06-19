package com.monkeys.deepcanyon.domain;

import org.junit.Assert;
import org.junit.Test;

public class MonkeyQueueTestCase {

	@Test
	public void testPeekEmptyQueue() {
		MonkeyQueue monkeyQueue = new MonkeyQueue(CrossDirection.EASTWARD);

		Assert.assertNull(monkeyQueue.peekMonkey());
	}

	@Test
	public void testPeekQueueWithOneMonkey() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		MonkeyQueue monkeyQueue = new MonkeyQueue(CrossDirection.EASTWARD);
		monkeyQueue.addMonkey(monkey);

		Assert.assertEquals(monkey, monkeyQueue.peekMonkey());
		Assert.assertEquals(monkey, monkeyQueue.peekMonkey());
		Assert.assertEquals(monkey, monkeyQueue.peekMonkey());
	}

	@Test
	public void testPeekQueueWithTwoMonkey() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		Monkey monkey2 = new Monkey(CrossDirection.EASTWARD);
		MonkeyQueue monkeyQueue = new MonkeyQueue(CrossDirection.EASTWARD);
		monkeyQueue.addMonkey(monkey);
		monkeyQueue.addMonkey(monkey2);

		Assert.assertEquals(monkey, monkeyQueue.peekMonkey());
		Assert.assertEquals(monkey, monkeyQueue.peekMonkey());
		Assert.assertEquals(monkey, monkeyQueue.peekMonkey());

		Assert.assertNotEquals(monkey2, monkeyQueue.peekMonkey());
	}

	@Test
	public void testPollEmptyQueue() {
		MonkeyQueue monkeyQueue = new MonkeyQueue(CrossDirection.EASTWARD);

		Assert.assertNull(monkeyQueue.pollMonkey());
	}

	@Test
	public void testPollQueueWithOneMonkey() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		MonkeyQueue monkeyQueue = new MonkeyQueue(CrossDirection.EASTWARD);
		monkeyQueue.addMonkey(monkey);

		Assert.assertEquals(monkey, monkeyQueue.pollMonkey());
		// Second time should be null.
		Assert.assertNull(monkeyQueue.pollMonkey());
	}

	@Test
	public void testPollQueueWithTwoMonkey() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		Monkey monkey2 = new Monkey(CrossDirection.EASTWARD);
		MonkeyQueue monkeyQueue = new MonkeyQueue(CrossDirection.EASTWARD);
		monkeyQueue.addMonkey(monkey);
		monkeyQueue.addMonkey(monkey2);

		Assert.assertEquals(monkey, monkeyQueue.pollMonkey());
		Assert.assertEquals(monkey2, monkeyQueue.pollMonkey());

		// Third time should be null.
		Assert.assertNull(monkeyQueue.pollMonkey());
	}

}
