import Creational_Patterns.AbstractFactory.ConcreteFactories.AirShippingFactory;
import Creational_Patterns.AbstractFactory.ConcreteFactories.BoatShippingFactory;
import Creational_Patterns.AbstractFactory.Factories.Factory;
import Creational_Patterns.Builder.Builders.GiftBoxBuilder;
import Creational_Patterns.Builder.Director;
import Creational_Patterns.Builder.GiftBoxes.GiftBox;
import Creational_Patterns.FactoryMethod.Ship;
import Creational_Patterns.FactoryMethod.ShippingFactory;
import Creational_Patterns.Singleton.Product;
import Creational_Patterns.Singleton.Singleton;
import Structural_Patterns.Adapter.AirShippingPrice;
import Structural_Patterns.Decorator.AppDecorator;
import Structural_Patterns.Decorator.Notification;
import Structural_Patterns.Decorator.Notifier;
import Structural_Patterns.Decorator.SMSDecorator;
import Structural_Patterns.Composite.FullOrder;
import Structural_Patterns.Interface.Interface;
import Structural_Patterns.Composite.OrderContents;
import Structural_Patterns.Composite.ProductsInBoxes;
import Structural_Patterns.Composite.SingleProducts;
import Structural_Patterns.Adapter.Price;
import Structural_Patterns.Adapter.PriceAdaptedEuro;
import Structural_Patterns.Adapter.PriceAdapter;

import static Creational_Patterns.Builder.Components.Color.*;
import static Creational_Patterns.Builder.Components.Contents.*;
import static Creational_Patterns.Builder.Components.Theme.*;
import static Creational_Patterns.Builder.GiftBoxes.BoxType.*;
import static Creational_Patterns.FactoryMethod.ShippingMethods.ShipMethods.*;
import static Structural_Patterns.Decorator.NotificationMethods.*;

public class TestCases {
    public static void testSingleton() {
        Singleton Client1 = Singleton.getInstance();
        Client1.AddProduct(new Product("Lipstick", "MAC", 300));
        Client1.AddProduct(new Product("Mascara", "ELF", 190));

        Singleton Client2 = Singleton.getInstance();
        Client2.AddProduct(new Product("Eyeshadow", "MAC", 900));

        System.out.println("If the same values are printed Creational_Patterns.Singleton is correct");
        Client1.PrintProductList();
        System.out.println();
        Client2.PrintProductList();
    }

    public static void testBuilder(){
        Director director = new Director();
        GiftBoxBuilder builder1 = new GiftBoxBuilder();
        GiftBoxBuilder builder2 = new GiftBoxBuilder();
        director.constructBigBox(builder1);
        director.constructSmallBox(builder2);
        GiftBox giftBox1 = builder1.getResult();
        GiftBox giftBox2 = builder2.getResult();
        System.out.println();
        System.out.println("Building Big Giftbox with Creational_Patterns.Builder pattern");
        System.out.println("Box built: \n" + giftBox1.getType() + " " + giftBox1.getColor() + " "+ giftBox1.getTheme() + " " + giftBox1.getContents());
        System.out.println();
        System.out.println("Building Small Giftbox with Creational_Patterns.Builder pattern");
        System.out.println("Box built: \n" + giftBox2.getType() + " " + giftBox2.getColor() + " "+ giftBox2.getTheme() + " " + giftBox2.getContents());
    }

    public static void testFactoryMethod(){
        ShippingFactory shippingFactory = new ShippingFactory();
        Ship ship = shippingFactory.shipOrder(AIR);
        System.out.println();
        System.out.println("Shipping orders using Factory method pattern");
        ship.shipProduct();
    }

    public static void testAbstractFactory(){
        System.out.println();
        System.out.println("Shipping and importing orders using Abstract Factory pattern");
        System.out.println();
        Factory factory1 = new AirShippingFactory();
        factory1.shipProduct().shipProduct();
        factory1.importProduct().importProduct();
        Factory factory2 = new BoatShippingFactory();
        factory2.importProduct().importProduct();
    }

    public static void testDecorator(){
        Notification notification = new Notifier();
        notification = new SMSDecorator(notification);
        notification = new AppDecorator(notification);
        System.out.println();
        notification.sendMessage("Your products have arrived");
    }

    public static void testInterface(){
        Interface anInterface = new Interface();
        anInterface.sendGiftBox(Small, AIR, SMS, "Your order has been sent");
    }

    public static void testComposite() {
        Product product1 = new Product("mascara", "Nyx", 122);
        OrderContents singleProducts = new SingleProducts(product1);
        GiftBox giftBox = new GiftBox(Small, White, Christmas, Hair_Products);
        OrderContents giftBoxes = new ProductsInBoxes(giftBox);
        FullOrder fullOrder = new FullOrder(1);
        fullOrder.addOrder(singleProducts);
        fullOrder.addOrder(giftBoxes);

        fullOrder.printOrderContents();
    }

    public static void testAdapter(){
        Price priceForAirShipping = new AirShippingPrice();
        PriceAdapter priceForAirShippingEuro = new PriceAdaptedEuro(priceForAirShipping);
        double priceLei = priceForAirShipping.getPrice();
        System.out.println("Price for Air Shipping in Lei: "+ priceLei);
        double priceEuro = priceForAirShippingEuro.getPrice();
        System.out.println("Price for Air Shipping in Euro: " + priceEuro);

    }
}
