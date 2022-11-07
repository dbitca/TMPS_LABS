package AbstractFactory.ConcreteFactories;

import AbstractFactory.Factories.Factory;
import AbstractFactory.Factories.Abstr_Import;
import AbstractFactory.Factories.Abstr_Ship;
import AbstractFactory.ImportMethods.AbstrImportByCar;
import AbstractFactory.ShippingMehods.AbstrShipByCar;

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
