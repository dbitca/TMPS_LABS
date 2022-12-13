package Creational_Patterns.AbstractFactory.ImportMethods;

import Creational_Patterns.AbstractFactory.Factories.Abstr_Import;

public class AbstrImportByBoat implements Abstr_Import {
    @Override
    public void importProduct() {
        System.out.println("Product is being imported by Boat");
    }
}
