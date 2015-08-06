/**
 * 
 */
package com.demo.app.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author vinay
 *
 */
public class CustomAppInitializer implements WebApplicationInitializer {

	/* (non-Javadoc)
	 * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
	 */
	 @Override
	    public void onStartup(ServletContext servletContext) throws ServletException {
	        WebApplicationContext context = getContext();
	        servletContext.addListener(new ContextLoaderListener(context));
	        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/");
	        System.out.println("inside initializer");
	    }

	    private AnnotationConfigWebApplicationContext getContext() {
	        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
	        context.setConfigLocation("com.demo.app.*");
	        return context;
	    }

}
