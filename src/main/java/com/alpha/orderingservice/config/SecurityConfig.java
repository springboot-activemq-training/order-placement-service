package com.alpha.orderingservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
//                .loginPage("/login.html") Your custom login page
                .defaultSuccessUrl("/orders")
                .and()
                .authorizeRequests()
                .mvcMatchers("/users/new", "/", "/users/register").permitAll()
//                .mvcMatchers("/orders").authenticated()
                .anyRequest().authenticated();


        return http.build();
    }


}
