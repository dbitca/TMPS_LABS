package FactoryMethod.ShippingMethods;

import FactoryMethod.Ship;

public class ShipByAir implements Ship {
    @Override
    public void shipProduct() {
        System.out.println("Your order has been shipped by air");
    }
}
