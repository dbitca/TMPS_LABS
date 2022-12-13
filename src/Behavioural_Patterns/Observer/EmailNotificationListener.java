package Behavioural_Patterns.Observer;

import Behavioural_Patterns.Observer.EventListener;
import Creational_Patterns.Builder.Components.Contents;

    public class EmailNotificationListener implements EventListener {
        private String email;

        public EmailNotificationListener(String email) {
            this.email = email;
        }

        @Override
        public void update(String eventType, Contents contents) {
            System.out.println("Email to " + email + ": Someone has performed " + eventType + " operation with the following product: " + contents.name());
        }
    }

