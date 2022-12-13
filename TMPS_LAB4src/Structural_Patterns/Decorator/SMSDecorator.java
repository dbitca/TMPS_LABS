package Structural_Patterns.Decorator;
//defining extra behaviours that can be added dynamically to components
public class SMSDecorator extends BaseDecorator{
    //using keyword super to mark the superclass
    public SMSDecorator(Notification wrapped) {
        super(wrapped);
    }
    //overriding the methods of the base decorator and execute behaviour
    //after the parent method is called
    @Override
    public void sendMessage(String msg){
        super.sendMessage(msg);
        sendSMS(msg);
    }
    private void sendSMS(String msg){
        System.out.println(msg + ", message sent in SMS");
    }
}
