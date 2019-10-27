package com.fovsoft.security.provider;

import com.fovsoft.security.vefify.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author: tpc
 * @date: 2019-10-11 20:51
 * @description:
 **/

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //获取表单中用户名
        String userName = (String)authentication.getPrincipal();

        //获取表单中密码
        String password = (String)authentication.getCredentials();

        System.out.println("principal:"+authentication.getPrincipal()+"auth:"+authentication.getAuthorities()+"cred"+authentication.getCredentials());
        System.out.println("表单提交东西");
        System.out.println(userName+"  "+password);


        User user = (User)customUserDetailsService.loadUserByUsername(userName);

        System.out.println("customUserDetails:"+user.getUsername());
        System.out.println(bCryptPasswordEncoder.encode(password));
        System.out.println(user.getPassword());
        //这里判断密码是否正确
        if(!(bCryptPasswordEncoder.matches(password,user.getPassword()))){
            throw new BadCredentialsException("password error");
        }
        //用户名和密码都正确后，注入自己的权限信息

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user,password,authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }


}
