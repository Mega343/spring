package com.nixsolutions.config;

import com.nixsolutions.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/resources/**", "/**").permitAll()
                .anyRequest().permitAll()
                .and();

        http.formLogin()
                .loginPage("/")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error")
                .usernameParameter("j_email")
                .passwordParameter("j_password")
                .defaultSuccessUrl("/main")
                .permitAll();

        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index?logout")
                .invalidateHttpSession(true);

        http.authorizeRequests()
                .antMatchers("/admin/").access("hasRole('ROLE_ADMIN')")
              //  .antMatchers("/").access("isAuthenticated()")
                .antMatchers("/main").access("permitAll")
                .antMatchers("/address/**").access("hasAnyAuthority('Librarian', 'Admin')")
                .antMatchers("/delete/**").access("hasAnyAuthority('Librarian', 'Admin')")
                .antMatchers("/document/**").access("hasAnyAuthority('Librarian', 'Admin')")
                .antMatchers("/update_user/**").access("hasAnyAuthority('Librarian', 'Admin')")
                .antMatchers("/awaiting_confirmation/**").access("hasAnyAuthority('Librarian', 'Admin')")
                .antMatchers("/books").access("hasAnyAuthority('Librarian', 'Admin')")
                .antMatchers("/book_delete/**").access("hasAnyAuthority('Librarian', 'Admin')")
                .antMatchers("/book_description").access("hasAnyAuthority('Librarian', 'Admin')")
                .antMatchers("/update_book/**").access("hasAnyAuthority('Librarian', 'Admin')")
                .antMatchers("/add_book").access("hasAnyAuthority('Librarian', 'Admin')")
                .antMatchers("/add_order").access("hasAnyAuthority('Librarian', 'Admin')")
                .antMatchers("/close/**").access("hasAnyAuthority('Librarian', 'Admin')")
                .antMatchers("/orders").access("hasAnyAuthority('Librarian', 'Admin')")
                .antMatchers("/registration").access("hasAnyAuthority('Librarian', 'Admin')")
                .and().formLogin();

    }

}
