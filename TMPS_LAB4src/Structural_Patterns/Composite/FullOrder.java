package Structural_Patterns.Composite;

import java.util.ArrayList;
import java.util.List;

public class FullOrder implements OrderContents {
    private Integer id;
    private List<OrderContents> orderContentsList;

    public FullOrder(Integer id) {
        this.id = id;
        this.orderContentsList = new ArrayList<>();
        //this.orderContentsList = orderContentsList;
    }

    @Override
    public void printOrderContents() {
        orderContentsList.forEach(OrderContents::printOrderContents);
    }

    public void addOrder(OrderContents orderContents){
        orderContentsList.add(orderContents);
    }

    public void removeOrder(OrderContents orderContents){
        orderContentsList.remove(orderContents);
    }
}
