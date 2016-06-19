package com.monkeys.deepcanyon.domain.state;

import org.junit.Before;

import com.monkeys.deepcanyon.domain.MonkeyFactory;

public abstract class BaseStateTestCase {
	@Before
	public void setUp() {
		MonkeyFactory.reset();
	}
}
