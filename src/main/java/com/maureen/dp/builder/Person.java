package com.maureen.dp.builder;

public class Person {
    int id;
    String name;
    int age;
    double weight;
    int score;
    Location loc;
}

class Location {
    String street;
    String roomNo;

    public Location(String street, String roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}