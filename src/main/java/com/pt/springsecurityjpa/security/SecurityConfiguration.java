package com.pt.springsecurityjpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {
    @Autowired
    UserDetailsService userDetailService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/admin","/showNewEmployee","/showNewCompany","/showFormForUpdate/{id}","/showFormForUpdateCompany/{id}","/deleteEmployee/{id}","/deleteCompany/{id}").hasRole("ADMIN")
                .antMatchers("/employee","/company").hasAnyRole("ADMIN","USER")
                .antMatchers("/").permitAll()
                .and().formLogin();
        http.csrf().disable();
        return http.build();
    }
    @Bean
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }
}