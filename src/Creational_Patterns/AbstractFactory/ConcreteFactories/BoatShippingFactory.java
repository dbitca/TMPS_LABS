package Creational_Patterns.AbstractFactory.ConcreteFactories;

import Creational_Patterns.AbstractFactory.Factories.Factory;
import Creational_Patterns.AbstractFactory.Factories.Abstr_Import;
import Creational_Patterns.AbstractFactory.Factories.Abstr_Ship;
import Creational_Patterns.AbstractFactory.ImportMethods.AbstrImportByBoat;
import Creational_Patterns.AbstractFactory.ShippingMehods.AbstrShipByBoat;

public class BoatShippingFactory implements Factory {
    @Override
    public Abstr_Ship shipProduct() {

        return new AbstrShipByBoat();
    }

    @Override
    public Abstr_Import importProduct() {

        return new AbstrImportByBoat();
    }
}
