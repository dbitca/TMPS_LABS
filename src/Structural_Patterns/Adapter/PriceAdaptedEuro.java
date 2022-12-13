package Structural_Patterns.Adapter;

public class PriceAdaptedEuro implements PriceAdapter{
    private Price ShippingPrice;

    public PriceAdaptedEuro(Price shippingPrice) {
        ShippingPrice = shippingPrice;
    }

    @Override
    public double getPrice() {
        return convertToEuro(ShippingPrice.getPrice());
    }
    private double convertToEuro(double price){
        return price / 20;
    }
}
