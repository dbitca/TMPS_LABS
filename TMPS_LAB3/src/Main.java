import Creational_Patterns.AbstractFactory.ConcreteFactories.AirShippingFactory;
import Creational_Patterns.AbstractFactory.ConcreteFactories.BoatShippingFactory;
import Creational_Patterns.AbstractFactory.Factories.Factory;
import Creational_Patterns.Builder.Builders.GiftBoxBuilder;
import Creational_Patterns.Builder.Director;
import Creational_Patterns.Builder.GiftBoxes.GiftBox;
import Creational_Patterns.FactoryMethod.Ship;
import Creational_Patterns.FactoryMethod.ShippingFactory;
import Creational_Patterns.Singleton.Singleton;
import Creational_Patterns.Singleton.Product;

public class Main {
    public static void main(String[] args) {
       //Creational_Patterns.Singleton pattern
        TestCases.testSingleton();
        //Creational_Patterns.Builder pattern
        TestCases.testBuilder();
        //Factory method pattern
        TestCases.testFactoryMethod();
        //Abstract factory method pattern
        TestCases.testAbstractFactory();
        // Decorator method
        TestCases.testDecorator();
        //Interface method
        TestCases.testInterface();
        //Composite method
        TestCases.testComposite();
        //Adapter method
        TestCases.testAdapter();
    }
}