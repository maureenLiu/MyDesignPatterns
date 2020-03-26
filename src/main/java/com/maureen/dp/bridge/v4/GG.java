package com.maureen.dp.bridge.v4;

public class GG {
    public void chase(MM mm) {
        Gift g = new WarmGift(new Flower());
        give(mm, g);
    }

    private void give(MM mm, Gift g) {
        System.out.println(g + " given!");
    }
}
