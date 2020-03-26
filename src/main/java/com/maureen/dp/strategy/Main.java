package com.maureen.dp.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Dog[] a = {new Dog(5), new Dog(3), new Dog(1)};
//        Sorter<Dog> sorter = new Sorter<>();
//        sorter.sort(a, new DogComparator());
//        System.out.println(Arrays.toString(a));


//        Cat[] c = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
//        Sorter<Cat> sorter = new Sorter<Cat>();
//        sorter.sort(c, new CatWeightComparator());
//        System.out.println(Arrays.toString(c));

        Cat[] c = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        Sorter<Cat> sorter = new Sorter<Cat>();
        //sorter.sort(c, new CatHeightComparator());
        sorter.sort(c, ((o1, o2) -> {
            if (o1.weight < o2.weight) return -1;
            else if (o1.weight > o2.weight) return 1;
            return 0;
        }));
        System.out.println(Arrays.toString(c));
    }
}
