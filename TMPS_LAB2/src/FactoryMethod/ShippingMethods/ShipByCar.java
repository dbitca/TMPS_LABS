package FactoryMethod.ShippingMethods;

import FactoryMethod.Ship;

public class ShipByCar implements Ship {

    @Override
    public void shipProduct() {
        System.out.println("Your order has been shipped by car");
    }
}
