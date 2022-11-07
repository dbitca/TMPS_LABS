package AbstractFactory.ShippingMehods;

import AbstractFactory.Factories.Abstr_Ship;

public class AbstrShipByBoat implements Abstr_Ship {

    @Override
    public void shipProduct() {
        System.out.println("Your order has been shipped by boat");
    }
}
