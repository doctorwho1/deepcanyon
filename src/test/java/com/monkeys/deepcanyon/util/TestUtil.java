package com.monkeys.deepcanyon.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyFactory;
import com.monkeys.deepcanyon.domain.Rope;

public class TestUtil {

	public static Monkey createWestwardMonkey() {
		return Monkey.builder().crossDirection(CrossDirection.WESTWARD).build();
	}

	public static Monkey createEastwardMonkey() {
		return Monkey.builder().crossDirection(CrossDirection.EASTWARD).build();
	}

	public static Rope createEmptyRope() {
		MonkeyFactory.getRopeInstance().reset();
		return MonkeyFactory.getRopeInstance();
	}

	public static Rope createFullRopeOfEastwardMonkeys() {
		return TestUtil.createFullRope(CrossDirection.EASTWARD);
	}

	public static Rope createFullRopeOfWestwardMonkeys() {
		return TestUtil.createFullRope(CrossDirection.WESTWARD);
	}

	private static Rope createFullRope(CrossDirection crossDirection) {
		Rope rope = TestUtil.createEmptyRope();
		DateTime currentTime = DateTime.now();

		for (int i = rope.getLength() - 1; i >= 0; i--) {

			DateTimeUtils.setCurrentMillisFixed(currentTime.minusSeconds(i).getMillis());
			rope.addMonkey(new Monkey(crossDirection));

		}

		DateTimeUtils.setCurrentMillisSystem();

		return rope;
	}

}
