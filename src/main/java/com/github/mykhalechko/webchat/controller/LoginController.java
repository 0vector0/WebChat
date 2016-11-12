package com.github.mykhalechko.webchat.controller;

import com.github.mykhalechko.webchat.entity.ChatUser;
import com.github.mykhalechko.webchat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

@RestController
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLogin() {
        ChatUser user = new ChatUser();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("urlpath", "/getLoginLink");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    //use spring-hateoas
    @RequestMapping(value = "/getLoginLink", method = RequestMethod.GET)
    @ResponseBody
    public ChatUser getChatUserLinkForSendingCredentials() throws NoSuchMethodException {
        Method verifyLoginMethod = LoginController.class.getMethod("verifyLogin", ChatUser.class, HttpSession.class);
        Link verifyLoginLink = ControllerLinkBuilder.linkTo(LoginController.class, verifyLoginMethod).withSelfRel();
        System.out.println(verifyLoginLink.getHref());
        ChatUser chatUser = new ChatUser();
        chatUser.add(verifyLoginLink);
        return chatUser;
    }

    @RequestMapping(value = "/verifyLogin", method = RequestMethod.POST)
    public ModelAndView verifyLogin(@RequestBody ChatUser chatUser, HttpSession session) {
        if (service.verifyLogin(chatUser)) {
            session.setAttribute("login", chatUser.getLogin());
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("user");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("index");
            return modelAndView;
        }
    }
}
