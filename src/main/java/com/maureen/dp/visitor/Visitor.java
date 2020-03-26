package com.maureen.dp.visitor;

public interface Visitor {
    void visitCpu(CPU cpu);

    void visitMemory(Memory memory);

    void visitBoard(Board board);
}
