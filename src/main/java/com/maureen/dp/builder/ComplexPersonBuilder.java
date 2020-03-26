package com.maureen.dp.builder;

public class ComplexPersonBuilder implements PersonBuilder {
    Person p = new Person();

    @Override
    public PersonBuilder basicInfo(int id, String name, int age) {
        p.id = id;
        p.name = name;
        p.age = age;
        return this;
    }

    @Override
    public PersonBuilder weight(double weight) {
        p.weight = weight;
        return this;
    }

    @Override
    public PersonBuilder score(int score) {
        p.score = score;
        return this;
    }

    @Override
    public PersonBuilder loc(String street, String roomNo) {
        p.loc = new Location(street, roomNo);
        return this;
    }

    @Override
    public Person build() {
        return p;
    }
}
