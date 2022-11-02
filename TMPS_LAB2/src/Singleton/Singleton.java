package Singleton;

import java.util.ArrayList;

public class Singleton {
private static Singleton instance;
private static  int count;
private ArrayList<Product> products = null;

//constructor for the singleton object
private Singleton(){
    count++;
    products = new ArrayList<Product>();
}
//creating a static method that controls access to the singleton instance
public static Singleton getInstance(){
    if (instance == null){
        instance = new Singleton();
    }
    return instance;
}
public void AddProduct(Product product)
{
    products.add(product);
}

public void PrintProductList(){
    for (Product p:products)
    System.out.println(p);
}
}
