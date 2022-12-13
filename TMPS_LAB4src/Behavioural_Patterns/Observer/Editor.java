package Behavioural_Patterns.Observer;

import Behavioural_Patterns.Observer.EventManager;
import Creational_Patterns.Builder.Components.Contents;

public class Editor {
    public EventManager events;
    public Contents contents;

    public Editor() {
        this.events = new EventManager("add", "remove");
    }

    public void addProduct(Contents contents){
        events.notify("add", contents);
    }

    public void saveProduct() throws Exception {
        if (this.contents != null) {
            events.notify("save", contents);
        } else {
            throw new Exception("Please add a product before sending.");
        }
    }
}
