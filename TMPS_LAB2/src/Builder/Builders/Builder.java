package Builder.Builders;

import Builder.Components.Color;
import Builder.Components.Contents;
import Builder.Components.Theme;
import Builder.GiftBoxes.BoxType;

public interface Builder {
    void setBoxType(BoxType type);
    void setColor (Color color);
    void setTheme (Theme theme);

    void setContents (Contents contents);
}
