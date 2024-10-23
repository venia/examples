package com.aquila.example.java.springintegration.listener;

import com.aquila.example.java.springintegration.adapter.mbean.OrderMBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;

import static org.junit.Assert.assertNotNull;

public class OrderAttributePollingTest {
    private ClassPathXmlApplicationContext context;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("spring-integration-context.xml");
    }

    @After
    public void destroy() {
        context.close();
    }

    @Test
    public void testOrderAttributePolling() throws InterruptedException {
        System.out.println("===============================[Start]==================================");
        OrderMBean orderMBean = context.getBean("orderMBean", OrderMBean.class);
        orderMBean.incrementOrder();
        Thread.sleep(4000);
        for (int i = 0; i < 100; i++) {
            QueueChannel processedOrders = context.getBean("processedOrders", QueueChannel.class);
            Message<?> processedMsg = processedOrders.receive(5000);
            assertNotNull(processedMsg);
            System.out.println("===================   Payload result: " + processedMsg.getPayload());
            orderMBean.incrementOrder();
            Thread.sleep(1000);
        }
        System.out.println("===============================[End]==================================");
    }
}
