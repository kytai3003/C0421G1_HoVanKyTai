package com.example.demo.config;

import com.example.demo.model.service.impl.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Phan quyen
            http.csrf().disable()
                    .formLogin()
                    .loginPage("/blog/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/blog/welcome", true).permitAll()
                    .and()

         // Cac trang khong yeu cau login

                    .authorizeRequests().antMatchers( "/catelogy/list", "/blog/search", "/blog/list").permitAll();

            http    .authorizeRequests().antMatchers("/blog/create", "/blog/edit**", "/blog/delete**", "/catelogy/create", "/catelogy/edit","/catelogy/edit/**", "/catelogy/delete")
                    .hasAuthority("admin")
                    .anyRequest().authenticated();

       // Remember me
            http.authorizeRequests().and().rememberMe()
                    .tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(10);
    }

    //Remember me
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return  inMemoryTokenRepository;
    }
}
