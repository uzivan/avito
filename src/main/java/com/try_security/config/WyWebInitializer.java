package com.try_security.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        System.out.println("+");
        return new Class[]{MyConfiguration.class};
    }
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
