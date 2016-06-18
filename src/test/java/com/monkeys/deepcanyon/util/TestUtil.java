package com.monkeys.deepcanyon.util;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;

public class TestUtil {

	private static final int DEFAULT_ROPE_LENGTH = 4;

	public static Rope createEmptyRope() {
		return new Rope(TestUtil.DEFAULT_ROPE_LENGTH);
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
