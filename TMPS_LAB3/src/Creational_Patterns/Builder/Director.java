package Creational_Patterns.Builder;

import Creational_Patterns.Builder.Builders.Builder;
import Creational_Patterns.Builder.Components.Color;
import Creational_Patterns.Builder.Components.Contents;
import Creational_Patterns.Builder.Components.Theme;
import Creational_Patterns.Builder.GiftBoxes.BoxType;

public class Director {
    public void constructSmallBox(Builder builder){
        builder.setBoxType(BoxType.Small);
        builder.setColor(Color.Black);
        builder.setTheme(Theme.Christmas);
        builder.setContents(Contents.Eye_Makeup);
    }

    public void constructBigBox(Builder builder){
        builder.setBoxType(BoxType.Big);
        builder.setColor(Color.Red);
        builder.setTheme(Theme.Valentines_Day);
        builder.setContents(Contents.Bath_Products);
    }

    public void constructMediumBox(Builder builder){
        builder.setBoxType(BoxType.Medium);
        builder.setColor(Color.White);
        builder.setTheme(Theme.Mothers_Day);
        builder.setContents(Contents.Hair_Products);
    }
}
