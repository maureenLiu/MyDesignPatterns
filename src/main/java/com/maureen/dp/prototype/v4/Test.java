package com.maureen.dp.prototype.v4;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2 = (Person) p1.clone();
        System.out.println("p1.loc == p2.loc?" + (p1.loc == p2.loc)); //Location中的StringBuilder指向同一个对象，所以如果要深克隆，要对StringBuilder进行深克隆

        p1.loc.street.reverse(); //p1中修改了StringBuilder的内容，p2中的也跟着改变了，因为指向的是同一个对象
        System.out.println(p2.loc.street);
    }
}


class Person implements Cloneable { //标记性接口，如果不实现该接口，编译不报错，但是运行会做检查
    int age = 8;
    int score = 100;

    Location loc = new Location(new StringBuilder("bj"), 22);

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
    StringBuilder street;
    int roomNo;

    public Location(StringBuilder street, int roomNo) {
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

