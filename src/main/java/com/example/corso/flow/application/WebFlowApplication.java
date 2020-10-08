package com.example.corso.flow.application;

import java.io.File;
import java.net.URL;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class WebFlowApplication {
	public static void main(String[] args) throws LifecycleException {
		Tomcat tomcat = new Tomcat();
		URL resource = WebFlowApplication.class.getResource("/webapps");
		String webappsDir, baseDir;
		if (resource.getProtocol().equals("jar")) {
			webappsDir = "/var/app/target/classes";
			baseDir = "/var/tmp/tomcat";
		} else {
			baseDir = new File(resource.getPath().substring(1).replace('/', File.separatorChar)).getParent();
			webappsDir = baseDir;
		}
		tomcat.setBaseDir(baseDir);
		tomcat.setPort(8080);
		tomcat.addWebapp("/webapp", new File(webappsDir, "webapp").getAbsolutePath());
		Context ctx = tomcat.addContext("", baseDir);
		tomcat.addServlet("", "grace-stop", new GracefulStopServlet(tomcat));
		ctx.addServletMappingDecoded("/stop", "grace-stop");
		tomcat.start();
		tomcat.getServer().await();
	}

}
