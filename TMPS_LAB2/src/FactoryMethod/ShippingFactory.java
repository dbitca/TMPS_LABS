package FactoryMethod;

import FactoryMethod.ShippingMethods.ShipByAir;
import FactoryMethod.ShippingMethods.ShipByBoat;
import FactoryMethod.ShippingMethods.ShipByCar;

public class ShippingFactory {
    public Ship shipOrder(String method){
        if (method == null)
            return null;
        switch(method){
            case "AIR":
                return new ShipByAir();
            case "BOAT":
                return new ShipByBoat();
            case "CAR":
                return new ShipByCar();
            default:
                throw new IllegalArgumentException("Unknown shipping method "+ method);
        }
    }
}
