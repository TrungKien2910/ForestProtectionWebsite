package com.stringboot.BaoVeRung.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig {
    @Autowired
    private CustomAuthenticationSuccessHandler customSuccessHandler;
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers("/default/images/**").permitAll()
                        .requestMatchers("/","/login", "/events/list-event", "events/event",
                                "blogs/list-blog","blogs/blog",
                                "schedules/list-schedule","schedules/schedule").permitAll()  // Cho phép truy cập không cần login
                        .requestMatchers("/blogs/blog-form-insert","blogs/save").hasRole("USER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/system/**").hasRole("SYSTEM")
                        .anyRequest().authenticated()
        ).formLogin(form->
                form.loginPage("/login")
                        .loginProcessingUrl("/authenticateTheUser")
                        .successHandler(customSuccessHandler)
                        .permitAll()
        )
                .logout(logout->logout.permitAll()
        )
                .exceptionHandling(configurer->
                        configurer.accessDeniedPage("/error")
                );
        return http.build();
    }
}
