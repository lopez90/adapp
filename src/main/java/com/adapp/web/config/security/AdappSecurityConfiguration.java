package com.adapp.web.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Dom on 22.06.2016.
 */

@Configuration
@EnableWebSecurity
public class AdappSecurityConfiguration extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {
       http
               .csrf().disable()
               .authorizeRequests()
                .anyRequest().permitAll()
                        .and()
               .formLogin()
                    .permitAll()
                    .and()
               .httpBasic();
    }

}
