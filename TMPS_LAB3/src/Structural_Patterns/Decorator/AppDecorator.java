package Structural_Patterns.Decorator;

public class AppDecorator extends BaseDecorator{

    public AppDecorator(Notification wrapped) {
        super(wrapped);
    }

    @Override
    public void sendMessage(String msg){
        super.sendMessage(msg);
        SendApp(msg);
    }

    private void SendApp(String msg){
        System.out.println(msg + ", message sent in app");
    }
}
