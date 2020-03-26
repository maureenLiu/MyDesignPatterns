package com.maureen.dp.command.cor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Content c = new Content();

        Command insertCommand = new InsertCommand(c);
        insertCommand.doit();
        insertCommand.undo();

        Command copyCommand = new CopyCommand(c);
        copyCommand.doit();
        copyCommand.undo();

        Command deleteCommand = new DeleteCommand(c);
        deleteCommand.doit();
        deleteCommand.undo();

        //Command模式与责任链模式一起使用，多次undo
        List<Command> commandList = new ArrayList<>();
        commandList.add(new InsertCommand(c));
        commandList.add(new CopyCommand(c));
        commandList.add(new DeleteCommand(c));
        for (Command command : commandList) {
            command.doit();
        }
        System.out.println(c.msg);

        for (int i = commandList.size(); i >= 0; i++) { //执行undo的顺序要与doit的顺序相反，才能撤销最近的操作
            commandList.get(i).undo();
        }
        System.out.println(c.msg);
    }
}
