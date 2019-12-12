package com.fovsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {

    @Autowired
    private SessionRegistry sessionRegistry;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "error";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        String sessionId = request.getRequestedSessionId();
        sessionRegistry.removeSessionInformation(sessionId);
        return "redirect:/login";
    }



    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forward:/hello3");
        return mv;
    }


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "王圣基");
        return "hello";
    }
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2(Model model) {
        model.addAttribute("name", "王圣基");
        return "idx";
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String hello3() {
        return "index";
    }
}
