package com.maureen.dp.prototype.v3;

/**
 * String需要进一步克隆吗？
 * 不需要，因为String类型是指定的常量值(bj、sh)，在常量池中；即便是new String，在堆里，但是还是指向的常量池中的值
 * String类无法克隆，String类并没有实现Cloneable
 */

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2 = (Person) p1.clone();
        System.out.println(p2.age + "," + p2.score);
        System.out.println(p2.loc);

        System.out.println(p1.loc == p2.loc);
        p1.loc.street = "sh";
        System.out.println(p2.loc);
    }
}


class Person implements Cloneable { //标记性接口，如果不实现该接口，编译不报错，但是运行会做检查
    int age = 8;
    int score = 100;

    Location loc = new Location("bj", 22);

    @Override
    public Object clone() throws CloneNotSupportedException {  //无Java源码，子类才能调用，所以必须重写变成public的
        Person p = (Person) super.clone();
        p.loc = (Location) loc.clone();
        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", score=" + score +
                ", loc=" + loc +
                '}';
    }
}

class Location implements Cloneable {
    String street;
    int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }
}
