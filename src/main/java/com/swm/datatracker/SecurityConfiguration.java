package com.swm.datatracker;

import com.swm.datatracker.respositories.UserRepository;
import com.swm.datatracker.services.UserDetailsLoader;
import com.swm.datatracker.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Properties;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usersLoader) // How to find users by their username
                .passwordEncoder(passwordEncoder()) // How to encode and verify passwords
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /* Login configuration */
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/") // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page

                /* Logout configuration */
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout") // append a query string value

                /* Pages that can be viewed without having to log in */
                .and()
                .authorizeRequests()
                .antMatchers("/sign-up",
                        "/users/**",
                        "/login",
                        "/**",
                        "/inventory",
                        "/inventory/{id}/edit",
                        "/inventory/create",
                        "/workorders",
                        "/work-order",
                        "/work-order/1",
                        "/work-order/**",
                        "/forgot",
                        "/users/forgot",
                        "/users/reset",
                        "/reset") // anyone can see the home work order create page

                .permitAll()

//                .and()
//                .authorizeRequests()
//                .antMatchers(
//                        "/admin/home",
//                        "/admin/orders",
//                        "/employee/home",
//                        "/employee/orders",
//                        "/user/profile",
//                        "/user/create"
//                )

                /* PAGES FOR EMPLOYEES */
//                .and()
//                .authorizeRequests()
//                .antMatchers(
//                        "/emp",
//                        "/emp/profile",
//                        "/emp/work-orders"
//                ).hasAuthority("ROLE_EDITOR")
//
//                /* Pages that require athentication */
//                .and()
//                .authorizeRequests()
//                .antMatchers(
//                        "/admin/home",
//                        "/admin/{id}/index", // only admins can view all work orders
//                        "/admin/{id}/show/{woID}", // only admins can view any one work order
//                        "/admin/{id}/create"
//                )
//                .hasAuthority("ROLE_ADMIN")
        ;
    }
}
