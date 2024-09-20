package com.aquila.example.java.springintegration.adapter.filter;

import org.springframework.messaging.Message;

public class MaxItemsFilter {
    private static int MAX_THRESHOLD = 10;

    public boolean checkThreshold(Message<?> orderId) {
        if (orderId.getPayload() != null) {
            Integer orderValue = (Integer) orderId.getPayload();

            if (orderValue > MAX_THRESHOLD) {
                return true;
            }
            return false;
        }
        return false;
    }
}
