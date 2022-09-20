package com.liparistudios.trainingreactjpa.config;

/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class MainSecurityConfig {


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (
                web -> web
                        .ignoring()
                        .antMatchers("classpath:/react/build/static/**", "classpath:/react/build/static/css/**", "classpath:/react/build/static/js/**")
        );
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                //.antMatchers("classpath:/react/build/static/**", "classpath:/react/build/static/css/**", "classpath:/react/build/static/js/**")
                .anyRequest()
                .permitAll()
                /*
                .authorizeHttpRequests(
                    authz -> authz
                        .anyRequest()
                        .permitAll()
                        //.authenticated()
                )
                .httpBasic(withDefaults())
                * /
        ;
        return http.build();
    }


}
        */