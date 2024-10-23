package com.aquila.example.java.jiraplugin.service.impl;

import com.aquila.example.java.jiraplugin.ApplicationConfig;
import com.aquila.example.java.jiraplugin.service.InnovatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class InnovatorServiceImpl implements InnovatorService, InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

    @Override
    public String getServiceName() {
        return "InnovatorServiceImpl getServiceName";
    }

    @Override
    public void afterPropertiesSet() {
        log.info("------------------------[InnovatorServiceImpl afterPropertiesSet]------------------------");
        System.out.println("------------------------[InnovatorServiceImpl afterPropertiesSet]------------------------");
    }
}
