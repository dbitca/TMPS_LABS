package OCP;

public class BookInvoice implements IInvoice {
    Book book;
    int quantity;

    public BookInvoice(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    @Override
    public void printInvoice() {
        System.out.println(quantity + " x " + book.name + " " + book.author + " " + book.price + "$");
    }
}
