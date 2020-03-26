package com.maureen.dp.builder;

//返回Builder对象是为了链式编程
public interface TerrainBuilder {
    TerrainBuilder buildWall();

    TerrainBuilder buildFort();

    TerrainBuilder buildMine();

    Terrain build();
}
