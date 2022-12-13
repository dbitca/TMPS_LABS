package Creational_Patterns.AbstractFactory.ShippingMehods;

import Creational_Patterns.AbstractFactory.Factories.Abstr_Ship;

public class AbstrShipByAir implements Abstr_Ship {
    @Override
    public void shipProduct() {
        System.out.println("Your order has been shipped by Air");
    }
}
