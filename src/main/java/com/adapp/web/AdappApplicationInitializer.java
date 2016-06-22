package com.adapp.web;

import com.adapp.web.config.WebConfiguration;
import com.adapp.web.config.persistance.PersistenceConfiguration;
import com.adapp.web.config.security.AdappSecurityConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Dom on 20.06.2016.
 */
@Order(1)
public class AdappApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{PersistenceConfiguration.class, AdappSecurityConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
