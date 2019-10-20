package com.fovsoft.controller;


import com.fovsoft.common.JsonResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;



@RestController
public class DemoController {
//    private Logger logger = LoggerFactory.getLogger(DemoController.class);
    private final Log logger = LogFactory.getLog(this.getClass());

    @RequestMapping("/test1")
    public JsonResult<Map> test1() {
        Map result = new HashMap();
        result.put("code", "200");
        result.put("msg", "OK");

        SecurityContext context = SecurityContextHolder.getContext();
        logger.info(String.valueOf(SecurityContextHolder.getInitializeCount()));

        Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(pricipal instanceof UserDetails) {
            String username = ((UserDetails)pricipal).getUsername();
            String password = ((UserDetails)pricipal).getPassword();
            Collection authoritiesList = ((UserDetails)pricipal).getAuthorities();

            logger.info(username);
            logger.info(password);

            for (Object o : authoritiesList) {
                logger.info("authority:" + ((GrantedAuthority)o).getAuthority());
            }


            Collection authoritiesList2 = context.getAuthentication().getAuthorities();
            for (Object o : authoritiesList2) {
                logger.info("authority2:" + ((GrantedAuthority)o).getAuthority());
            }
        }
        else {
            logger.info(pricipal.toString());
        }

        return new JsonResult<>(result);
    }

    @RequestMapping("/test2")
    public void test2() {
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        logger.info(securityContext);
//        securityContext.setAuthentication();
    }

    @RequestMapping("/getMap")
    public JsonResult<Map> getMap() {
        Map result = new HashMap();
        result.put("code", "200");
        result.put("msg", "OK");
        result.put("som", null);

        return new JsonResult<>(result);
    }
}
