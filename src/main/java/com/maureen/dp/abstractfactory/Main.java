package com.maureen.dp.abstractfactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory f = new ModernFactory();//如果是其他工厂，只需要修改这个地方即可；如果是写在config里，这个代码就不用修改，只需要修改config即可

        Vehicle v = f.createVehicle();
        v.go();

        Food food = f.createFood();
        food.printName();

        Weapon w = f.createWeapon();
        w.shoot();
    }
}
