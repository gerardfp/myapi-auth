package com.example.myapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                    .anonymous()
                .and()
                    .authorizeRequests()
                        .antMatchers(HttpMethod.GET,"/hello/**")
                        .permitAll()
                .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/movies/**")
                    .hasAuthority("SCOPE_read")
                    .antMatchers(HttpMethod.POST, "/actors/**")
                    .hasAuthority("SCOPE_write")

//                .anyRequest()
//                .authenticated()

                .and()
                .oauth2ResourceServer()
                .jwt();
    }
}
