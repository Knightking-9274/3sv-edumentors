package com.edumentors.backend.configuration;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;


import com.edumentors.backend.services.implementations.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    

    @Autowired
    CustomUserDetailService userDetailsService;
    //Configuration of authentication provider
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider =  new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity httpSecurity)throws Exception{
        //configuration of accessible url's
        httpSecurity.authorizeHttpRequests(auth->{
            auth.requestMatchers("/user/**").authenticated();
            auth.anyRequest().permitAll();
        });
        // form default login
        httpSecurity.formLogin(login->{
            login.loginPage("/login");
            login.loginProcessingUrl("/authenticate");
            login.usernameParameter("email");
            login.passwordParameter("password");
            login.defaultSuccessUrl("/user/user-dashboard", true);            ;
            login.failureForwardUrl("/login?error=true");
            
            // login.failureHandler(new AuthenticationFailureHandler() {

            //     @Override
            //     public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            //             AuthenticationException exception) throws IOException, ServletException {
            //         
            //         throw new UnsupportedOperationException("Unimplemented method 'onAuthenticationFailure'");
            //     }
                
            // });
            // login.successHandler(new AuthenticationSuccessHandler() {

            //     @Override
            //     public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            //             Authentication authentication) throws IOException, ServletException {
            //         
            //         throw new UnsupportedOperationException("Unimplemented method 'onAuthenticationSuccess'");
            //     }
                
            // });
        });
        httpSecurity.logout(logOut->{
            logOut.logoutUrl("/logout");
        });
        return httpSecurity.build();

    }
    
}
