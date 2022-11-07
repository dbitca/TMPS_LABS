package AbstractFactory.ImportMethods;

import AbstractFactory.Factories.Abstr_Import;

public class AbstrImportByBoat implements Abstr_Import {
    @Override
    public void importProduct() {
        System.out.println("Product is being imported by Boat");
    }
}
