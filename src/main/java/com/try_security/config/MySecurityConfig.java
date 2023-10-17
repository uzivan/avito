package com.try_security.config;//package com.try_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/addOrder").hasRole("BUYER")
                .antMatchers("/cart").hasRole("BUYER")
                .antMatchers("/deleteFromCart").hasRole("BUYER")
                .antMatchers("/set").hasRole("SALESMAN")
                .and()
                .formLogin().loginPage("/")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/show", true)
                .failureUrl("/hello?error=true");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("Ivan").password("qwe").roles("DIRECTOR", "HR"))
//                .withUser(userBuilder.username("Kate").password("asd").roles("HR"))
//                .withUser(userBuilder.username("Zxc").password("zxc").roles("WORKER"));
    }

}
