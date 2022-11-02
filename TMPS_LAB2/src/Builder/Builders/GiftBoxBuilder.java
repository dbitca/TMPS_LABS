package Builder.Builders;

import Builder.Components.Color;
import Builder.Components.Contents;
import Builder.Components.Theme;
import Builder.GiftBoxes.BoxType;
import Builder.GiftBoxes.GiftBox;

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
