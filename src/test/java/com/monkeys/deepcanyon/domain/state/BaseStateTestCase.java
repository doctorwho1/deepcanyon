package com.monkeys.deepcanyon.domain.state;

import org.joda.time.DateTimeUtils;
import org.junit.Before;

import com.monkeys.deepcanyon.domain.MonkeyFactory;

public abstract class BaseStateTestCase {
	@Before
	public final void setUp() {
		MonkeyFactory.reset();
		DateTimeUtils.setCurrentMillisSystem();

	}
}
