package Creational_Patterns.Builder.Builders;

import Creational_Patterns.Builder.Components.Color;
import Creational_Patterns.Builder.Components.Contents;
import Creational_Patterns.Builder.Components.Theme;
import Creational_Patterns.Builder.GiftBoxes.BoxType;
import Creational_Patterns.Builder.GiftBoxes.GiftBox;

public class GiftBoxBuilder implements Builder {
    private BoxType type;
    private Color color;
    private Theme theme;
    private Contents contents;

    @Override
    public void setBoxType(BoxType type) {
        this.type = type;
    }

    @Override
    public void setColor(Color color) {
    this.color = color;
    }

    @Override
    public void setTheme(Theme theme) {
    this.theme = theme;
    }

    @Override
    public void setContents(Contents contents) {
        this.contents = contents;
    }

    public GiftBox getResult(){
        return new GiftBox(type,color,theme, contents);
    }
}
