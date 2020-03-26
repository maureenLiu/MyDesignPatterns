package com.maureen.dp.observer.v9;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Button_ b = new Button_();
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        b.buttonPressed();
    }
}

class ActionEvent_ {
    long when;
    Object source;

    public ActionEvent_(long when, Object source) {
        this.when = when;
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public long getWhen() {
        return when;
    }
}

interface ActionListener_ {
    public void actionPerformed(ActionEvent_ e);
}

class Button_ {
    private List<ActionListener_> actionListeners = new ArrayList<>();

    public void addActionListener(ActionListener_ l) {
        actionListeners.add(l);
    }

    public void buttonPressed() {
        ActionEvent_ e = new ActionEvent_(System.currentTimeMillis(), this);
        for (int i = 0; i < actionListeners.size(); i++) {
            ActionListener_ l = actionListeners.get(i);
            l.actionPerformed(e);
        }
    }

}

class MyActionListener implements ActionListener_ {

    @Override
    public void actionPerformed(ActionEvent_ e) {
        System.out.println("button pressed!");
    }
}

class MyActionListener2 implements ActionListener_ {

    @Override
    public void actionPerformed(ActionEvent_ e) {
        System.out.println("button pressed 2!");
    }
}

