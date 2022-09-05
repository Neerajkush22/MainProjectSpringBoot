package com.SpringBootProject.EmployeeManagementSystem.Config;

import com.SpringBootProject.EmployeeManagementSystem.Security.EmployeeSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private EmployeeSecurity employee;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/Organisation").hasAnyAuthority("Admin","Employee","HR")
                .antMatchers(HttpMethod.GET,"/api/Organisation/getById/{id}").hasAnyAuthority("Admin","Employee","HR")
                .antMatchers(HttpMethod.DELETE,"/api/Organisation/deleteById/{id}").hasAuthority("Admin")
                .antMatchers(HttpMethod.POST,"/api/Organisation").hasAuthority("Admin")
                .antMatchers(HttpMethod.PUT,"/api/Organisation/updateById/**").hasAuthority("Admin")

                .antMatchers(HttpMethod.GET,"/employeerole/{id}").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.GET,"/employeerole").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.PUT,"/employeerole").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.POST,"/employeerole").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.DELETE,"/employeerole/{id}").hasAnyAuthority("Admin")

                .antMatchers(HttpMethod.GET,"/api/Employee").hasAnyAuthority("Admin","HR")
                .antMatchers(HttpMethod.POST,"/api/Employee").hasAnyAuthority("Admin","HR")
                .antMatchers(HttpMethod.PUT,"/api/Employee/updateById/**").hasAnyAuthority("Admin","HR")
                .antMatchers(HttpMethod.DELETE,"/api/Employee/deleteById/**").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.GET, "/api/Employee/login/{id}").hasAnyAuthority("Employee")


                .antMatchers(HttpMethod.GET,"/Assets").hasAnyAuthority("Admin","HR","Employee")
                .antMatchers(HttpMethod.PUT,"/api/Assets/updateById/{id}").hasAnyAuthority("Admin","HR")
                .antMatchers(HttpMethod.POST,"/api/Assets").hasAnyAuthority("Admin","HR")
                .antMatchers(HttpMethod.GET,"/api/Assets/getById/{id}").hasAnyAuthority("Admin","HR","Employee")
                .antMatchers(HttpMethod.PUT,"/api/Assets/updateById/{id}").hasAnyAuthority("Admin","HR")
                .antMatchers(HttpMethod.DELETE,"/api/Assets/deleteById/{id}").hasAuthority("Admin")
                .and().httpBasic();

        http.csrf().disable();

    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(employee).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}




