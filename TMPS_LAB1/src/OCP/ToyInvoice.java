package OCP;

public class ToyInvoice implements IInvoice {
    Toy toy;
    int quantity;

    public ToyInvoice(Toy toy, int quantity) {
        this.toy = toy;
        this.quantity = quantity;
    }

    @Override
    public void printInvoice() {
        System.out.println(quantity + " x " + toy.type + " " + toy.colour + " " + toy.price + "$");

    }
}
