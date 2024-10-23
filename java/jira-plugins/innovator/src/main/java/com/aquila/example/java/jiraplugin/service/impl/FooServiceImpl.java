package com.aquila.example.java.jiraplugin.service.impl;

import com.aquila.example.java.jiraplugin.service.FooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class FooServiceImpl implements FooService, InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(FooServiceImpl.class);

    public void init() {
        log.info("===============[FooServiceImpl init]===============");
    }

    @Override
    public String getServiceName() {
        return "FooServiceImpl->getServiceName";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("===============[FooServiceImpl afterPropertiesSet]===============");
    }
}
