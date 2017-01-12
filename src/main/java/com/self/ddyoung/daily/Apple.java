package com.self.ddyoung.daily;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 16/12/22 下午6:13
 */
public class Apple {

    @FruitName("Apple")
    private String appleName;

    @FruitColor(colorValue = FruitColor.Color.Red)
    private String appleColor;

    public void displayName() {
        System.out.println("水果的名称是：" + appleName);
        System.out.println("水果的颜色是：" + appleColor);
    }
}
