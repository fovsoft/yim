package com.fovsoft.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().passwordEncoder(new pE())
                .withUser("zhangWuJi").password("123456").roles("topLevel")
                .and()
                .withUser("guoJing").password("123456").roles("senior")
                .and()
                .withUser("yangGuo").password("123456").roles("middleRank", "primary")
                .and()
                .withUser("weiXiaoBao").password("123456").roles("primary");
    }

    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests()
                .antMatchers("/login1").hasRole("topLevel")
                .antMatchers("/getMap").hasAnyRole("topLevel", "senior");

        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin();
        http.logout();
    }}

class pE implements PasswordEncoder {
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}