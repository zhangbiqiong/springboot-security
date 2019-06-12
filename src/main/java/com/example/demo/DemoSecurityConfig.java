package com.example.demo;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests()
		// .antMatchers("/greeting").authenticated()
        // .anyRequest().permitAll();
        http.authorizeRequests()
            .antMatchers("/greeting").authenticated()
            .anyRequest().permitAll()
            .and()
            .formLogin();
        // http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
		// .withUser("user1").password("pswd123").roles("ADMIN").and()
        .withUser("admin").password("{noop}admin").roles("ADMIN");
    }



}