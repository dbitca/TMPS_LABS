package Creational_Patterns.Builder.GiftBoxes;

import Creational_Patterns.Builder.Components.Color;
import Creational_Patterns.Builder.Components.Contents;
import Creational_Patterns.Builder.Components.Theme;

public class GiftBox {
    private final BoxType type;
    private final Color color;
    private final Theme theme;
    private final Contents contents;

    public GiftBox(BoxType type, Color color, Theme theme, Contents contents) {
        this.type = type;
        this.color = color;
        this.theme = theme;
        this.contents = contents;
    }

    public BoxType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public Theme getTheme() {
        return theme;
    }

    public Contents getContents() {
        return contents;
    }
}
