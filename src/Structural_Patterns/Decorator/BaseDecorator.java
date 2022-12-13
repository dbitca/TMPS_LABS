package Structural_Patterns.Decorator;

public class BaseDecorator implements Notification{
    //field for referencing a wrapped object.
    private Notification wrapped;

    @Override
    public void sendMessage(String msg) {
        wrapped.sendMessage(msg);
    }
    //all operations are delegated to the wrapped object by the base decorator
    public BaseDecorator(Notification wrapped){
        this.wrapped  = wrapped;
    }
}
