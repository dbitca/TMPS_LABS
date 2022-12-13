package Behavioural_Patterns.Observer;

import Creational_Patterns.Builder.Components.Contents;

public interface EventListener {
    void update(String eventType, Contents contents);
}
