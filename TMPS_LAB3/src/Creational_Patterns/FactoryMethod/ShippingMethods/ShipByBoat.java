package Creational_Patterns.FactoryMethod.ShippingMethods;

import Creational_Patterns.FactoryMethod.Ship;

public class ShipByBoat implements Ship {

    @Override
    public void shipProduct() {
        System.out.println("Your order has been shipped by boat");
    }
}
