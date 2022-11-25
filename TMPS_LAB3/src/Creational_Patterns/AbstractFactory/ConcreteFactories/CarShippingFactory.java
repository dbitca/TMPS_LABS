package Creational_Patterns.AbstractFactory.ConcreteFactories;

import Creational_Patterns.AbstractFactory.Factories.Factory;
import Creational_Patterns.AbstractFactory.Factories.Abstr_Import;
import Creational_Patterns.AbstractFactory.Factories.Abstr_Ship;
import Creational_Patterns.AbstractFactory.ImportMethods.AbstrImportByCar;
import Creational_Patterns.AbstractFactory.ShippingMehods.AbstrShipByCar;

public class CarShippingFactory implements Factory {
    @Override
    public Abstr_Ship shipProduct() {
        return new AbstrShipByCar();
    }

    @Override
    public Abstr_Import importProduct() {

        return new AbstrImportByCar();
    }
}
