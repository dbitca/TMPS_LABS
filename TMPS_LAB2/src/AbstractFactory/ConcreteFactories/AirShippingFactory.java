package AbstractFactory.ConcreteFactories;

import AbstractFactory.Factories.Factory;
import AbstractFactory.Factories.Abstr_Import;
import AbstractFactory.Factories.Abstr_Ship;
import AbstractFactory.ImportMethods.AbstrImportByAir;
import AbstractFactory.ShippingMehods.AbstrShipByAir;

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
