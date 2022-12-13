package Structural_Patterns.Adapter;

public class ShipShippingPrice implements Price{
    @Override
    public double getPrice() {
        return 1500;
    }
}
