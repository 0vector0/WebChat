package com.github.mykhalechko.webchat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class ChatController {

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public ModelAndView chatAccess(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        if (session.getAttribute("login") != null) {
            modelAndView.addObject("user", session.getAttribute("login"));
            modelAndView.setViewName("chat");
        } else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}
