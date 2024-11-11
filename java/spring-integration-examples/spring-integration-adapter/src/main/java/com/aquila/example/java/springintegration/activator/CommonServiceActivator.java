package com.aquila.example.java.springintegration.activator;

import org.springframework.messaging.Message;

public class CommonServiceActivator {
    public String attributePolled (Message<?> msg) {
        return  "Order Id ::" + msg.getPayload().toString() + " is being processed";
    }
}