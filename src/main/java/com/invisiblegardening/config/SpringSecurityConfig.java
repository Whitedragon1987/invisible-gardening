package com.invisiblegardening.config;

import com.invisiblegardening.filter.JwtRequestFilter;
import com.invisiblegardening.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //JWT token authentication
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/users").permitAll()
                .antMatchers(HttpMethod.POST,"/users").permitAll()
                .antMatchers("/userdata/users").hasRole("ADMIN")
                .antMatchers("/userdata/**").hasRole("USER")
                .antMatchers("/userdata/**").hasRole("ADMIN")
                .antMatchers("/users/all").hasRole("ADMIN")
                .antMatchers("/users/**").hasRole("USER")
                .antMatchers("/users/**").hasRole("ADMIN")
                .antMatchers("/reviews/**").hasRole("USER")
                .antMatchers("/reviews/**").hasRole("ADMIN")
                .antMatchers("/requests/**").hasRole("USER")
                .antMatchers("/requests/**").hasRole("ADMIN")
                .antMatchers("/quotes/**").hasRole("USER")
                .antMatchers("/quotes/**").hasRole("ADMIN")
                .antMatchers("/machines/**").hasRole("USER")
                .antMatchers("/machines/**").hasRole("ADMIN")
                .antMatchers("/jobs/**").hasRole("USER")
                .antMatchers("/jobs/**").hasRole("ADMIN")
                .antMatchers("/authenticated").authenticated()
                .antMatchers("/authenticate").permitAll()
                .anyRequest().permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

}