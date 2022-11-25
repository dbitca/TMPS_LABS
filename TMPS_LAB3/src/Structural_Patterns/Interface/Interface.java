package Structural_Patterns.Interface;

import Creational_Patterns.Builder.Builders.GiftBoxBuilder;
import Creational_Patterns.Builder.Director;
import Creational_Patterns.Builder.GiftBoxes.BoxType;
import Creational_Patterns.Builder.GiftBoxes.GiftBox;
import Creational_Patterns.FactoryMethod.Ship;
import Creational_Patterns.FactoryMethod.ShippingFactory;
import Creational_Patterns.FactoryMethod.ShippingMethods.ShipMethods;
import Structural_Patterns.Decorator.*;
import Creational_Patterns.FactoryMethod.ShippingFactory;

public class Interface {
    public void sendGiftBox(BoxType type, ShipMethods shippingMethod, NotificationMethods notificationMethod, String notificationmessage){
        //Choosing Shipping type
        var shippingFactory = new ShippingFactory();
        Ship ship = shippingFactory.shipOrder(shippingMethod);
        ship.shipProduct();

        //Choosing notification method
        Notification notification = new Notifier();
        switch(notificationMethod){
            case EMAIL -> notification.sendMessage(notificationmessage);
            case SMS -> {
                notification = new SMSDecorator(notification);
                notification.sendMessage(notificationmessage);
            }
            case APP -> {
                notification = new AppDecorator(notification);
                notification.sendMessage(notificationmessage);
            }
        }

        // Choosing and creating box type to sent
        Director director = new Director();
        GiftBoxBuilder builder = new GiftBoxBuilder();
        GiftBox giftBox = null;
        switch (type){
            case Small:
                director.constructSmallBox(builder);
                giftBox = builder.getResult();
            case Big:
                director.constructBigBox(builder);
                 giftBox = builder.getResult();
            case Medium:
                director.constructMediumBox(builder);
                giftBox = builder.getResult();
        }
        System.out.println();
        System.out.println("Building Giftbox with Creational_Patterns.Builder pattern");
        System.out.println("Box built: \n" + giftBox.getType() + " " + giftBox.getColor() + " "+ giftBox.getTheme() + " " + giftBox.getContents());
    }
}
