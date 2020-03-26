package com.maureen.dp.command.cor;

public class InsertCommand extends Command {
    Content c;
    String strToInsert = "http://www.maureen.com";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msg = c.msg + strToInsert;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() - strToInsert.length());
    }
}
