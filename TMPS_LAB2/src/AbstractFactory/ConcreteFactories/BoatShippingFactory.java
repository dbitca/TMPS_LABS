package AbstractFactory.ConcreteFactories;

import AbstractFactory.Factories.Factory;
import AbstractFactory.Factories.Abstr_Import;
import AbstractFactory.Factories.Abstr_Ship;
import AbstractFactory.ImportMethods.AbstrImportByBoat;
import AbstractFactory.ShippingMehods.AbstrShipByBoat;

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
