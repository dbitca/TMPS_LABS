package Creational_Patterns.AbstractFactory.ConcreteFactories;

import Creational_Patterns.AbstractFactory.Factories.Factory;
import Creational_Patterns.AbstractFactory.Factories.Abstr_Import;
import Creational_Patterns.AbstractFactory.Factories.Abstr_Ship;
import Creational_Patterns.AbstractFactory.ImportMethods.AbstrImportByAir;
import Creational_Patterns.AbstractFactory.ShippingMehods.AbstrShipByAir;

public class AirShippingFactory implements Factory {

    @Override
    public Abstr_Ship shipProduct() {
       return new AbstrShipByAir();
    }
    
    @Override
    public Abstr_Import importProduct() {
       return new AbstrImportByAir();
    }
}
