package com.adapp.web;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by Dom on 22.06.2016.
 */
@Order(2)
public class AdappSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
