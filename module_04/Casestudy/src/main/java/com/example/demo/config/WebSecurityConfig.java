package com.example.demo.config;


import com.example.demo.model.service.security.MyUserDetailServiceImpl;
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
        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/home").permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
                .and().authorizeRequests().antMatchers("/employee/list", "/customer/list", "/service/list", "/contract/list").hasAnyRole("EMPLOYEE", "DIRECTOR", "MANAGER")
                .and()
                .authorizeRequests().antMatchers("/employee/create", "/employee/save", "/employee/edit/**","/employee/edit","/employee/delete",
                "/customer/create", "/customer/save", "/customer/edit/**","/customer/edit","/customer/delete",
                "/service/create", "/service/save", "/service/delete",
                "/contract/create", "/contract/save", "/contract/contract-detail/create", "/contract/contract-detail/save")
                .hasAnyRole("DIRECTOR", "MANAGER").and().exceptionHandling().accessDeniedPage("/403");
//                .and()
//                .authorizeRequests().anyRequest().authenticated();


        http.authorizeRequests().and().rememberMe()
                .tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(60);
    }

    //Remember me
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return  inMemoryTokenRepository;
    }
}
