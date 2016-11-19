package com.github.mykhalechko.webchat.controller;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class ChatController {


    @Resource
    private Environment env;

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public ModelAndView chatAccess(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("login " + session.getAttribute("login"));
        if (session.getAttribute("login") != null) {
            System.out.println("login121212 " + session.getAttribute("login"));

            modelAndView.addObject("user", session.getAttribute("login"));
            modelAndView.addObject("socketUrl", env.getRequiredProperty("socket.url"));
            modelAndView.setViewName("chat");
        } else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}
