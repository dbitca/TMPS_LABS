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

    }
}