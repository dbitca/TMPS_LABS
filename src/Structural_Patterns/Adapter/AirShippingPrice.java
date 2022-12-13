package Structural_Patterns.Adapter;

public class AirShippingPrice implements Price{

    @Override
    public double getPrice() {
        return 2000;
    }
}
