package com.maureen.dp.builder;

public interface PersonBuilder {
    PersonBuilder basicInfo(int id, String name, int age);

    PersonBuilder weight(double weight);

    PersonBuilder score(int score);

    PersonBuilder loc(String street, String roomNo);

    Person build();
}
