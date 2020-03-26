package com.maureen.dp.state.v3;

public abstract class CarState {
    abstract void open();

    abstract void closed();

    abstract void running();

    abstract void stopped();
}
