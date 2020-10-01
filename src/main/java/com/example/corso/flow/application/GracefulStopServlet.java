package com.example.corso.flow.application;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class GracefulStopServlet extends HttpServlet {

    private Tomcat tomcat;

    public GracefulStopServlet(Tomcat tomcat) {
        this.tomcat = tomcat;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CompletableFuture.runAsync(this::stop);
        resp.sendError(HttpStatus.ACCEPTED.value());
    }

    private void stop() {
        try {
            tomcat.stop();
        } catch (LifecycleException e) {
            LoggerFactory.getLogger(getClass()).error("Error while gracefully stopping Tomcat", e);
        }
    }
}
