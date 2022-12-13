package Creational_Patterns.FactoryMethod;

import Creational_Patterns.FactoryMethod.ShippingMethods.ShipByAir;
import Creational_Patterns.FactoryMethod.ShippingMethods.ShipByBoat;
import Creational_Patterns.FactoryMethod.ShippingMethods.ShipByCar;
import Creational_Patterns.FactoryMethod.ShippingMethods.ShipMethods;

public class ShippingFactory {
    public Ship shipOrder(ShipMethods method){
        if (method == null)
            return null;
        switch(method){
            case AIR:
                return new ShipByAir();
            case BOAT:
                return new ShipByBoat();
            case CAR:
                return new ShipByCar();
            default:
                throw new IllegalArgumentException("Unknown shipping method "+ method);
        }
    }
}
