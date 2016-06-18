package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;

public interface MonkeyState {

	MonkeyState handle(Monkey monkey, Rope rope);

}
