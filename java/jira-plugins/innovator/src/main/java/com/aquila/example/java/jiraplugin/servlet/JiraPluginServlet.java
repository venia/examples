package com.aquila.example.java.jiraplugin.servlet;

import com.aquila.example.java.jiraplugin.service.FooService;
import com.aquila.example.java.jiraplugin.service.InnovatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JiraPluginServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(JiraPluginServlet.class);

    private InnovatorService innovatorService;

    private FooService fooService;

    @Inject
    public JiraPluginServlet(@Qualifier("innovatorService") InnovatorService innovatorService, FooService fooService) {
        this.innovatorService = innovatorService;
        this.fooService = fooService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        log.debug("=======================[JiraPluginServlet called]=======================");
        String innovatorServiceName = innovatorService.getServiceName();
        String fooServiceName = fooService.getServiceName();
        String appender = "<h1>Service: " + innovatorServiceName + "</h1>";
        appender += "<h1>Service: " + fooServiceName + "</h1>";
        resp.setContentType("text/html");
        String message = "<html><body><h1>Hello service: " + appender + "</h1></body></html>";
        resp.getWriter().write(message);
    }

}