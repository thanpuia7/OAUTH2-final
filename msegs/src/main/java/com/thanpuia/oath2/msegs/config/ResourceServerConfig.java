package com.thanpuia.oath2.msegs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 *The @EnableResourceServer annotation adds a filter of type OAuth2AuthenticationProcessingFilter automatically
 *to the Spring Security filter chain.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .headers()
                .frameOptions()
                .disable()
                .and()
            .authorizeRequests()
                .antMatchers("/","/home","/register","/login","/add").permitAll()
                .antMatchers("/private/**","/view/**","/update","/changePass").authenticated()
                .antMatchers("/adminView","/adminUpdate","/adminView").hasRole("ADMIN");
                //.antMatchers("/add").hasAnyRole("ADMIN","USER");
    }


}
