package Singleton;

public class Product {
    public String name;
    public String brand;
    public int price;

    public Product(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
    @Override
public String toString(){
        return this.brand + " " + this.name + " " + this.price;
}

}
