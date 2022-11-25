package Structural_Patterns.Adapter;

public class CarShippingPrice implements Price{

    @Override
    public double getPrice() {
        return 200;
    }
}
