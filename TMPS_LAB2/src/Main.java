import Builder.Builders.GiftBoxBuilder;
import Builder.Director;
import Builder.GiftBoxes.GiftBox;
import FactoryMethod.Ship;
import FactoryMethod.ShippingFactory;
import Singleton.Singleton;
import Singleton.Product;

public class Main {
    public static void main(String[] args) {
       //Singleton pattern
        Singleton Client1  = Singleton.getInstance();
        Client1.AddProduct(new Product("Lipstick", "MAC", 300));
        Client1.AddProduct(new Product("Mascara", "ELF", 190));

        Singleton Client2 = Singleton.getInstance();
        Client2.AddProduct(new Product("Eyeshadow", "MAC", 900));

        System.out.println("If the same values are printed Singleton is correct");
        Client1.PrintProductList();
        System.out.println();
        Client2.PrintProductList();

        //Builder pattern
        Director director = new Director();
        GiftBoxBuilder builder1 = new GiftBoxBuilder();
        GiftBoxBuilder builder2 = new GiftBoxBuilder();
        director.constructBigBox(builder1);
        director.constructSmallBox(builder2);
        GiftBox giftBox1 = builder1.getResult();
        GiftBox giftBox2 = builder2.getResult();
        System.out.println();
        System.out.println("Building Big Giftbox with Builder pattern");
        System.out.println("Box built: \n" + giftBox1.getType() + " " + giftBox1.getColor() + " "+ giftBox1.getTheme() + " " + giftBox1.getContents());
        System.out.println();
        System.out.println("Building Small Giftbox with Builder pattern");
        System.out.println("Box built: \n" + giftBox2.getType() + " " + giftBox2.getColor() + " "+ giftBox2.getTheme() + " " + giftBox2.getContents());

        //Factory method pattern
        ShippingFactory shippingFactory = new ShippingFactory();
        Ship ship = shippingFactory.shipOrder("AIR");
        System.out.println();
        System.out.println("Shipping orders using Factory method pattern");
        ship.shipProduct();
    }
}