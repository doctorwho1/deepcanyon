package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;

public class CrossingRopeState extends BaseMonkeyState {

	public int currentRopePosition;
	
	

	public CrossingRopeState(Monkey monkey, Rope rope, int currentRopePosition) {
		super(monkey, rope);
		this.currentRopePosition = currentRopePosition;
	}


	public MonkeyState handle(Monkey monkey, Rope rope) {

		if (this.isNextPositionEndOfRope(monkey, rope)) {
			rope.putMonkey(this.currentRopePosition, null);
			return MonkeyStateFactory.createCrossedRopeState(this.monkey);

		} else if (this.isNextPositionAvailable(monkey, rope)) {
			// TODO: El mono por un instante está en 2 sitios a la vez.
			// Podríamos decir que está a mitad de movimiento :D.
			int nextPosition = this.nextPosition(monkey, rope);
			rope.putMonkey(nextPosition, monkey);

			// FIXME: Esto introduce errores cambiar cómo almacenamos los monos
			// a un array.
			rope.putMonkey(currentRopePosition, null);
			this.currentRopePosition = nextPosition;

		}

		return this;
	}

	public int getCurrentRopePosition() {
		return currentRopePosition;
	}

	private boolean isNextPositionEndOfRope(Monkey monkey, Rope rope) {

		return this.nextPosition(monkey, rope) < 0 || this.nextPosition(monkey, rope) >= rope.getLength();
	}

	private boolean isNextPositionAvailable(Monkey monkey, Rope rope) {

		return rope.getMonkey(this.nextPosition(monkey, rope)) == null;
	}

	private int nextPosition(Monkey monkey, Rope rope) {
		switch (monkey.getCrossDirection()) {
		case EASTWARD:
			return this.currentRopePosition + 1;

		case WESTWARD:
			return this.currentRopePosition - 1;
		default:
			throw new IllegalStateException("Monkey should have a cross direction");

		}
	}

}
