package com.example.corso.flow.application;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.net.URL;

public class WebFlowApplication {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        URL resource = WebFlowApplication.class.getResource("/webapps");
        String webappsDir = resource.getPath().substring(1).replace('/', File.separatorChar);
        String baseDir = new File(webappsDir).getParent();
        tomcat.setBaseDir(baseDir);
        tomcat.setPort(8080);
        Context ctx = tomcat.addWebapp("", new File(baseDir, "webapp").getAbsolutePath());
        tomcat.addServlet("", "grace-stop", new GracefulStopServlet(tomcat));
        ctx.addServletMappingDecoded("/stop", "grace-stop");
        tomcat.start();
        tomcat.getServer().await();
    }

}
