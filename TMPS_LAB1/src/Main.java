import OCP.*;
import SRP.Product;
import SRP.Printer;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        SRP();
        System.out.println();
        OCP();
    }

    public static void SRP() {
        System.out.println("Single responsibility principle:");
        var product = new Product("iPhone 5s", 1000, 3);
        var productPrice = product.CalculateTotal();
        var printer = new Printer();
        printer.Print(productPrice);
    }

    public static void OCP(){
        System.out.println("Open closed principle:");
        var car = new Car("Mercedes", "Negru", 200000, 2022);
        var carInvoice = new CarInvoice(car, 3);
        carInvoice.printInvoice();

        var book = new Book("Capra cu trei iezi", 2, "Ion Creanga");
        var bookInvoice = new BookInvoice(book, 3);
        bookInvoice.printInvoice();

        var toy = new Toy("Titirez", "Roz", 30);
        var toyInvoice = new ToyInvoice(toy, 2);
        toyInvoice.printInvoice();
    }
}