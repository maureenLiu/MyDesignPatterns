package com.maureen.dp.builder;

/**
 * 针对要构建的对象参数很多的时候，可以使用Builder模式
 * 可以灵活地决定要使用哪些参数，对属性进行分组
 */
public class Main {
    public static void main(String[] args) {
        TerrainBuilder terrainBuilder = new ComplexTerrainBuilder();
        Terrain t = terrainBuilder.buildWall().buildFort().buildMine().build();

        PersonBuilder personBuilder = new ComplexPersonBuilder();
        Person p = personBuilder.basicInfo(1, "zhangsan", 18)
                .score(20)
                .weight(200)
                .loc("bj", "23")
                .build();

    }
}
