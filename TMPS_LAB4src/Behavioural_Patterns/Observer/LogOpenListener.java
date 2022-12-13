package Behavioural_Patterns.Observer;

import Creational_Patterns.Builder.Components.Contents;

import java.io.File;

public class LogOpenListener implements EventListener {
    public File log;

    public LogOpenListener(String fileName){
       this.log = new File (fileName);
    }
    @Override
    public void update(String eventType, Contents contents) {
        System.out.println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following contents: " + contents);
    }
}
