package OCP;

public class CarInvoice implements IInvoice{
    public Car car;
    int quantity;

    public CarInvoice(Car car, int quantity) {
        this.car = car;
        this.quantity = quantity;
    }

    @Override
    public void printInvoice() {
        System.out.println(quantity + " x " + car.brand + " " + car.colour + " " +  car.year + " " + car.price + "$");
    }
}
