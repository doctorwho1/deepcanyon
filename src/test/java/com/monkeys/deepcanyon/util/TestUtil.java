package com.monkeys.deepcanyon.util;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;
import com.monkeys.deepcanyon.domain.state.MonkeyFactory;

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

		for (int i = 0; i < rope.getLength(); i++) {
			rope.putMonkey(i, new Monkey(crossDirection));
		}

		return rope;
	}

}
