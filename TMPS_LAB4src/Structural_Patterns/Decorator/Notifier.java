package Structural_Patterns.Decorator;
//this class defines the basic behaviour of sending email, which
//can be altered by decorators
public class Notifier implements Notification{
    @Override
    public void sendMessage(String msg) {
        System.out.println(msg + " ,message sent in email");
    }
}
