package Structural_Patterns.Composite;

import Creational_Patterns.Builder.GiftBoxes.GiftBox;

public class ProductsInBoxes implements OrderContents {
    private GiftBox giftBox;

    public ProductsInBoxes(GiftBox giftBox) {
        this.giftBox = giftBox;
    }

    @Override
    public void printOrderContents() {
        System.out.println(giftBox.getContents() + " " + giftBox.getTheme() + " "+ giftBox.getColor() + " " + giftBox.getType());
    }
}
