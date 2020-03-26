package com.maureen.dp.state.v3;

//Car的State与Action
public class Car {
    CarState carState;

    public void open() {
        carState.open();
    }

    public void close() {
        carState.closed();
    }

    public void run() {
        carState.running();
    }

    public void stop() {
        carState.stopped();
    }
}
