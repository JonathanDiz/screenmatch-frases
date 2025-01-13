package com.jonathandiz.screen_match.security;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
          .csrf().disable()
          .authorizeRequests()
          .antMatchers("/login", "/register").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin().loginPage("/login").permitAll();
    }
}
