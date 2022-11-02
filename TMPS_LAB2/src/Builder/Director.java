package Builder;

import Builder.Builders.Builder;
import Builder.Components.Color;
import Builder.Components.Contents;
import Builder.Components.Theme;
import Builder.GiftBoxes.BoxType;

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
