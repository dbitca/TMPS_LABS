package Creational_Patterns.Builder.Builders;

import Creational_Patterns.Builder.Components.Color;
import Creational_Patterns.Builder.Components.Contents;
import Creational_Patterns.Builder.Components.Theme;
import Creational_Patterns.Builder.GiftBoxes.BoxType;

public interface Builder {
    void setBoxType(BoxType type);
    void setColor (Color color);
    void setTheme (Theme theme);

    void setContents (Contents contents);
}
