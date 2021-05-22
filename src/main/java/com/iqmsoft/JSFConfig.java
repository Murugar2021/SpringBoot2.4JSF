package com.iqmsoft;

import com.sun.faces.config.ConfigureListener;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;


@Configuration
public class JSFConfig implements ServletContextAware{

    @Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                new FacesServlet(), "*.jsf");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(
                new ConfigureListener());
    }

    @Override
    public void setServletContext(ServletContext sc) {
        sc.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
    }
    
}
