package com.fovsoft.security;

import com.fovsoft.security.provider.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

/**
 * 本身最为配置类，
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    /**
     * 配置认证
     *
     * @param auth
     * @throws Exception
     */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new pE())
//                .withUser("zhangWuJi").password("123456").roles("topLevel", "primary")
//                .and()
//                .withUser("guoJing").password("123456").roles("senior")
//                .and()
//                .withUser("yangGuo").password("123456").roles("middleRank", "primary")
//                .and()
//                .withUser("weiXiaoBao").password("123456").roles("primary");

        auth.authenticationProvider(customAuthenticationProvider);
    }

    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests()
                .antMatchers("/test2").permitAll()
                .antMatchers("/test1").hasRole("topLevel")
                .antMatchers("/getMap").hasAnyRole("topLevel", "senior")
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/authentication/form").failureUrl("/error").defaultSuccessUrl("/family").permitAll();
        http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN));  // frame页面的地址只能为同源域名下的页面
        http.authorizeRequests().anyRequest().authenticated();
//        http.formLogin();

//        http.logout().
//                logoutUrl("/logout").permitAll().
//                invalidateHttpSession(true).
//                deleteCookies("JSESSIONID").
//                logoutSuccessUrl("/login");
//                and().sessionManagement().maximumSessions(10).expiredUrl("/login");

        http.logout();
    }

    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/assets/**");
    }
}

