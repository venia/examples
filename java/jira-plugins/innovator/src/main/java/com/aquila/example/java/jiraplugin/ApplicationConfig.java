package com.aquila.example.java.jiraplugin;

import com.aquila.example.java.jiraplugin.service.InnovatorService;
import com.aquila.example.java.jiraplugin.service.impl.InnovatorServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import javax.inject.Named;

@Named
@Configuration
public class ApplicationConfig {
    private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

    @Bean(name = "innovatorService")
    public InnovatorService innovatorService() {
        Message<String> messasge = new GenericMessage("innovator");
        log.info("===========================> GenericMessage" + messasge.getPayload());
        log.info("===========================[InnovatorConfiguration.innovatorService]=============================");
        System.out.println("===========================[InnovatorConfiguration.innovatorService]=============================");
        return new InnovatorServiceImpl();
    }
}
