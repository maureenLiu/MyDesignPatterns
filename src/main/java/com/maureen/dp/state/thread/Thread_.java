package com.maureen.dp.state.thread;

/**
 * 有限状态机的模拟
 */
public class Thread_ {
    ThreadState_ state;

    void move(Action input) {
        state.move(input);
    }

    void run() {
        state.run();
    }
}
