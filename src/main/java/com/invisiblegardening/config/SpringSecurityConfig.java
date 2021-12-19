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
//        antmatchers that are commented out don't work in combination with React, resolve later. For backend use only (postman) they work fine

        //JWT token authentication
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(HttpMethod.GET,"/userdata/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/userdata/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/userdata/{id}").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/userdata").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.PUT,"/userdata/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/userdata/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/users/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/users/{username}").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/users").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.PUT,"/users/{username}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/users/{username}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/users/{username}/authorities").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/users/{username}/authorities").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/users/{username}/authority}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/users/{username}/{userdataId}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/reviews").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET,"/reviews/{id}").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.PUT,"/reviews/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/reviews/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/reviews/{id}/picture").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET,"/requests").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/requests/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/requests").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.PUT,"/requests/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/quotes").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/quotes/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/quotes").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.DELETE,"/quotes/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/quotes/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/quotes/quote/{id}/picture").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/quotes/{id}/userdata").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET,"/pictures").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/pictures/upload").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.DELETE,"/pictures/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/machines").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET,"/machines/{id}").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/machines").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/machines/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/machines/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/machines/machine/{id}/picture").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/jobs").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET,"/jobs/{id}").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/jobs").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/jobs/{id}/employee/{employeeId}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/jobs/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/jobs/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/jobs/job/{id}/picture").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET,"/employees").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/employees/{id}").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/employees").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/employees/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/employees/{id}").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

}