package com.fovsoft.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义的加密器
 */
public class Pe implements PasswordEncoder{
        public String encode(CharSequence rawPassword) {
            return rawPassword.toString();
        }

        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            return encodedPassword.equals(rawPassword.toString());
        }
}
