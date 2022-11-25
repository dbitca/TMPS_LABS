package Structural_Patterns.Composite;

import Creational_Patterns.Singleton.Product;

public class SingleProducts implements OrderContents{
    public SingleProducts(Product product) {
        this.product = product;
    }

    private Product product;
    @Override
    public void printOrderContents() {
        System.out.println(product.brand + " " + product.name + " " + product.price);
    }
}
